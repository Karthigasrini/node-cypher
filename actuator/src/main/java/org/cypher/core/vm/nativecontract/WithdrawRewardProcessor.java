package org.cypher.core.vm.nativecontract;

import static org.cypher.core.actuator.ActuatorConstant.ACCOUNT_EXCEPTION_STR;
import static org.cypher.core.actuator.ActuatorConstant.STORE_NOT_EXIST;

import com.google.common.math.LongMath;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.cypher.common.parameter.CommonParameter;
import org.cypher.common.utils.StringUtil;
import org.cypher.core.capsule.AccountCapsule;
import org.cypher.core.exception.ContractExeException;
import org.cypher.core.exception.ContractValidateException;
import org.cypher.core.vm.nativecontract.param.WithdrawRewardParam;
import org.cypher.core.vm.repository.Repository;
import org.cypher.core.vm.utils.VoteRewardUtil;

@Slf4j(topic = "VMProcessor")
public class WithdrawRewardProcessor {

  public void validate(WithdrawRewardParam param, Repository repo) throws ContractValidateException {
    if (repo == null) {
      throw new ContractValidateException(STORE_NOT_EXIST);
    }

    byte[] ownerAddress = param.getOwnerAddress();

    boolean isGP = CommonParameter.getInstance()
        .getGenesisBlock().getWitnesses().stream().anyMatch(witness ->
            Arrays.equals(ownerAddress, witness.getAddress()));
    if (isGP) {
      throw new ContractValidateException(
          ACCOUNT_EXCEPTION_STR + StringUtil.encode58Check(ownerAddress)
              + "] is a guard representative and is not allowed to withdraw Balance");
    }
  }

  public long execute(WithdrawRewardParam param, Repository repo) throws ContractExeException {
    byte[] ownerAddress = param.getOwnerAddress();

    VoteRewardUtil.withdrawReward(ownerAddress, repo);

    AccountCapsule accountCapsule = repo.getAccount(ownerAddress);
    long oldBalance = accountCapsule.getBalance();
    long allowance = accountCapsule.getAllowance();
    long newBalance = 0;

    try {
      newBalance = LongMath.checkedAdd(oldBalance, allowance);
    } catch (ArithmeticException e) {
      logger.debug(e.getMessage(), e);
      throw new ContractExeException(e.getMessage());
    }

    // If no allowance, do nothing and just return zero.
    if (allowance <= 0) {
      return 0;
    }

    accountCapsule.setInstance(accountCapsule.getInstance().toBuilder()
        .setBalance(newBalance)
        .setAllowance(0L)
        .setLatestWithdrawTime(param.getNowInMs())
        .build());

    repo.updateAccount(accountCapsule.createDbKey(), accountCapsule);
    return allowance;
  }
}
