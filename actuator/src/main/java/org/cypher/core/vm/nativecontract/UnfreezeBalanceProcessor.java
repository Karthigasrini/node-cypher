package org.cypher.core.vm.nativecontract;

import static org.cypher.core.actuator.ActuatorConstant.STORE_NOT_EXIST;
import static org.cypher.core.config.Parameter.ChainConstant.CYP_PRECISION;

import com.google.common.collect.Lists;
import com.google.protobuf.ByteString;
import java.util.Iterator;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.cypher.common.utils.FastByteComparisons;
import org.cypher.core.capsule.AccountCapsule;
import org.cypher.core.capsule.DelegatedResourceCapsule;
import org.cypher.core.capsule.VotesCapsule;
import org.cypher.core.exception.ContractValidateException;
import org.cypher.core.vm.config.VMConfig;
import org.cypher.core.vm.nativecontract.param.UnfreezeBalanceParam;
import org.cypher.core.vm.repository.Repository;
import org.cypher.core.vm.utils.VoteRewardUtil;
import org.cypher.protos.Protocol;

@Slf4j(topic = "VMProcessor")
public class UnfreezeBalanceProcessor {

  public void validate(UnfreezeBalanceParam param, Repository repo)
      throws ContractValidateException {
    if (repo == null) {
      throw new ContractValidateException(STORE_NOT_EXIST);
    }

    byte[] ownerAddress = param.getOwnerAddress();
    AccountCapsule ownerCapsule = repo.getAccount(ownerAddress);
    byte[] receiverAddress = param.getReceiverAddress();
    long now = repo.getDynamicPropertiesStore().getLatestBlockHeaderTimestamp();
    if (!FastByteComparisons.isEqual(ownerAddress, receiverAddress)) {
      param.setDelegating(true);

      // check if delegated resource exists
      byte[] key = DelegatedResourceCapsule.createDbKey(ownerAddress, receiverAddress);
      DelegatedResourceCapsule delegatedResourceCapsule = repo.getDelegatedResource(key);
      if (delegatedResourceCapsule == null) {
        throw new ContractValidateException("delegated Resource does not exist");
      }

      // validate args @frozenBalance and @expireTime
      switch (param.getResourceType()) {
        case BANDWIDTH:
          // validate frozen balance
          if (delegatedResourceCapsule.getFrozenBalanceForBandwidth() <= 0) {
            throw new ContractValidateException("no delegatedFrozenBalance(BANDWIDTH)");
          }
          // check if it is time to unfreeze
          if (delegatedResourceCapsule.getExpireTimeForBandwidth() > now) {
            throw new ContractValidateException("It's not time to unfreeze(BANDWIDTH).");
          }
          break;
        case ENERGY:
          // validate frozen balance
          if (delegatedResourceCapsule.getFrozenBalanceForEnergy() <= 0) {
            throw new ContractValidateException("no delegateFrozenBalance(Energy)");
          }
          // check if it is time to unfreeze
          if (delegatedResourceCapsule.getExpireTimeForEnergy() > now) {
            throw new ContractValidateException("It's not time to unfreeze(Energy).");
          }
          break;
        default:
          throw new ContractValidateException("ResourceCode error."
              + "valid ResourceCode[BANDWIDTH、Energy]");
      }
    } else {
      switch (param.getResourceType()) {
        case BANDWIDTH:
          // validate frozen balance
          if (ownerCapsule.getFrozenCount() <= 0) {
            throw new ContractValidateException("no frozenBalance(BANDWIDTH)");
          }
          // check if it is time to unfreeze
          long allowedUnfreezeCount = ownerCapsule.getFrozenList().stream()
              .filter(frozen -> frozen.getExpireTime() <= now).count();
          if (allowedUnfreezeCount <= 0) {
            throw new ContractValidateException("It's not time to unfreeze(BANDWIDTH).");
          }
          break;
        case ENERGY:
          Protocol.Account.Frozen frozenForEnergy = ownerCapsule.getAccountResource()
              .getFrozenBalanceForEnergy();
          // validate frozen balance
          if (frozenForEnergy.getFrozenBalance() <= 0) {
            throw new ContractValidateException("no frozenBalance(Energy)");
          }
          // check if it is time to unfreeze
          if (frozenForEnergy.getExpireTime() > now) {
            throw new ContractValidateException("It's not time to unfreeze(Energy).");
          }
          break;
        default:
          throw new ContractValidateException("ResourceCode error."
              + "valid ResourceCode[BANDWIDTH、Energy]");
      }
    }
  }

  public long execute(UnfreezeBalanceParam param, Repository repo) {
    byte[] ownerAddress = param.getOwnerAddress();
    byte[] receiverAddress = param.getReceiverAddress();

    AccountCapsule accountCapsule = repo.getAccount(ownerAddress);
    long oldBalance = accountCapsule.getBalance();
    long unfreezeBalance = 0L;

    if (param.isDelegating()) {
      byte[] key = DelegatedResourceCapsule.createDbKey(ownerAddress, receiverAddress);
      DelegatedResourceCapsule delegatedResourceCapsule = repo.getDelegatedResource(key);

      // reset delegated resource and deduce delegated balance
      switch (param.getResourceType()) {
        case BANDWIDTH:
          unfreezeBalance = delegatedResourceCapsule.getFrozenBalanceForBandwidth();
          delegatedResourceCapsule.setFrozenBalanceForBandwidth(0, 0);
          accountCapsule.addDelegatedFrozenBalanceForBandwidth(-unfreezeBalance);
          break;
        case ENERGY:
          unfreezeBalance = delegatedResourceCapsule.getFrozenBalanceForEnergy();
          delegatedResourceCapsule.setFrozenBalanceForEnergy(0, 0);
          accountCapsule.addDelegatedFrozenBalanceForEnergy(-unfreezeBalance);
          break;
        default:
          //this should never happen
          break;
      }
      repo.updateDelegatedResource(key, delegatedResourceCapsule);

      // take back resource from receiver account
      AccountCapsule receiverCapsule = repo.getAccount(receiverAddress);
      if (receiverCapsule != null) {
        switch (param.getResourceType()) {
          case BANDWIDTH:
            receiverCapsule.safeAddAcquiredDelegatedFrozenBalanceForBandwidth(-unfreezeBalance);
            break;
          case ENERGY:
            receiverCapsule.safeAddAcquiredDelegatedFrozenBalanceForEnergy(-unfreezeBalance);
            break;
          default:
            //this should never happen
            break;
        }
        repo.updateAccount(receiverCapsule.createDbKey(), receiverCapsule);
      }

      // increase balance of owner
      accountCapsule.setBalance(oldBalance + unfreezeBalance);
    } else {
      switch (param.getResourceType()) {
        case BANDWIDTH:
          List<Protocol.Account.Frozen> frozenList = Lists.newArrayList();
          frozenList.addAll(accountCapsule.getFrozenList());
          Iterator<Protocol.Account.Frozen> iterator = frozenList.iterator();
          long now = repo.getDynamicPropertiesStore().getLatestBlockHeaderTimestamp();
          while (iterator.hasNext()) {
            Protocol.Account.Frozen next = iterator.next();
            if (next.getExpireTime() <= now) {
              unfreezeBalance += next.getFrozenBalance();
              iterator.remove();
            }
          }
          accountCapsule.setInstance(accountCapsule.getInstance().toBuilder()
              .setBalance(oldBalance + unfreezeBalance)
              .clearFrozen().addAllFrozen(frozenList).build());
          break;
        case ENERGY:
          unfreezeBalance = accountCapsule.getAccountResource().getFrozenBalanceForEnergy()
              .getFrozenBalance();
          Protocol.Account.AccountResource newAccountResource =
              accountCapsule.getAccountResource().toBuilder()
              .clearFrozenBalanceForEnergy().build();
          accountCapsule.setInstance(accountCapsule.getInstance().toBuilder()
              .setBalance(oldBalance + unfreezeBalance)
              .setAccountResource(newAccountResource).build());
          break;
        default:
          //this should never happen
          break;
      }

    }

    // adjust total resource, used to be a bug here
    switch (param.getResourceType()) {
      case BANDWIDTH:
        repo.addTotalNetWeight(-unfreezeBalance / CYP_PRECISION);
        break;
      case ENERGY:
        repo.addTotalEnergyWeight(-unfreezeBalance / CYP_PRECISION);
        break;
      default:
        //this should never happen
        break;
    }

    repo.updateAccount(accountCapsule.createDbKey(), accountCapsule);

    if (VMConfig.allowTvmVote() && !accountCapsule.getVotesList().isEmpty()) {
      long usedCypherPower = 0;
      for (Protocol.Vote vote : accountCapsule.getVotesList()) {
        usedCypherPower += vote.getVoteCount();
      }
      if (accountCapsule.getCypherPower() < usedCypherPower * CYP_PRECISION) {
        VoteRewardUtil.withdrawReward(ownerAddress, repo);
        VotesCapsule votesCapsule = repo.getVotes(ownerAddress);
        accountCapsule = repo.getAccount(ownerAddress);
        if (votesCapsule == null) {
          votesCapsule = new VotesCapsule(ByteString.copyFrom(ownerAddress),
              accountCapsule.getVotesList());
        } else {
          votesCapsule.clearNewVotes();
        }
        accountCapsule.clearVotes();
        repo.updateVotes(ownerAddress, votesCapsule);
        repo.updateAccount(ownerAddress, accountCapsule);
      }
    }

    return unfreezeBalance;
  }
}
