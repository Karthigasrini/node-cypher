package org.cypher.core.actuator;

import static org.cypher.core.actuator.ActuatorConstant.ACCOUNT_EXCEPTION_STR;
import static org.cypher.core.actuator.ActuatorConstant.NOT_EXIST_STR;
import static org.cypher.core.actuator.ActuatorConstant.PROPOSAL_EXCEPTION_STR;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.cypher.common.utils.ByteArray;
import org.cypher.common.utils.DecodeUtil;
import org.cypher.common.utils.StringUtil;
import org.cypher.core.capsule.ProposalCapsule;
import org.cypher.core.capsule.TransactionResultCapsule;
import org.cypher.core.exception.ContractExeException;
import org.cypher.core.exception.ContractValidateException;
import org.cypher.core.exception.ItemNotFoundException;
import org.cypher.core.store.AccountStore;
import org.cypher.core.store.DynamicPropertiesStore;
import org.cypher.core.store.ProposalStore;
import org.cypher.protos.Protocol.Proposal.State;
import org.cypher.protos.Protocol.Transaction.Contract.ContractType;
import org.cypher.protos.Protocol.Transaction.Result.code;
import org.cypher.protos.contract.ProposalContract.ProposalDeleteContract;

@Slf4j(topic = "actuator")
public class ProposalDeleteActuator extends AbstractActuator {

  public ProposalDeleteActuator() {
    super(ContractType.ProposalDeleteContract, ProposalDeleteContract.class);
  }

  @Override
  public boolean execute(Object result) throws ContractExeException {
    TransactionResultCapsule ret = (TransactionResultCapsule) result;
    if (Objects.isNull(ret)) {
      throw new RuntimeException(ActuatorConstant.TX_RESULT_NULL);
    }

    long fee = calcFee();
    ProposalStore proposalStore = chainBaseManager.getProposalStore();
    try {
      final ProposalDeleteContract proposalDeleteContract = this.any
          .unpack(ProposalDeleteContract.class);
      ProposalCapsule proposalCapsule = proposalStore.
          get(ByteArray.fromLong(proposalDeleteContract.getProposalId()));
      proposalCapsule.setState(State.CANCELED);
      proposalStore.put(proposalCapsule.createDbKey(), proposalCapsule);

      ret.setStatus(fee, code.SUCESS);
    } catch (InvalidProtocolBufferException | ItemNotFoundException e) {
      logger.debug(e.getMessage(), e);
      ret.setStatus(fee, code.FAILED);
      throw new ContractExeException(e.getMessage());
    }
    return true;
  }

  @Override
  public boolean validate() throws ContractValidateException {
    if (this.any == null) {
      throw new ContractValidateException(ActuatorConstant.CONTRACT_NOT_EXIST);
    }
    if (chainBaseManager == null) {
      throw new ContractValidateException(ActuatorConstant.STORE_NOT_EXIST);
    }
    AccountStore accountStore = chainBaseManager.getAccountStore();
    ProposalStore proposalStore = chainBaseManager.getProposalStore();
    DynamicPropertiesStore dynamicStore = chainBaseManager.getDynamicPropertiesStore();
    if (!this.any.is(ProposalDeleteContract.class)) {
      throw new ContractValidateException(
          "contract type error,expected type [ProposalDeleteContract],real type[" + any
              .getClass() + "]");
    }
    final ProposalDeleteContract contract;
    try {
      contract = this.any.unpack(ProposalDeleteContract.class);
    } catch (InvalidProtocolBufferException e) {
      throw new ContractValidateException(e.getMessage());
    }

    byte[] ownerAddress = contract.getOwnerAddress().toByteArray();
    String readableOwnerAddress = StringUtil.createReadableString(ownerAddress);

    if (!DecodeUtil.addressValid(ownerAddress)) {
      throw new ContractValidateException("Invalid address");
    }

    if (!accountStore.has(ownerAddress)) {
      throw new ContractValidateException(ACCOUNT_EXCEPTION_STR + readableOwnerAddress
          + NOT_EXIST_STR);
    }

    long latestProposalNum = dynamicStore
        .getLatestProposalNum();
    if (contract.getProposalId() > latestProposalNum) {
      throw new ContractValidateException(PROPOSAL_EXCEPTION_STR + contract.getProposalId()
          + NOT_EXIST_STR);
    }

    ProposalCapsule proposalCapsule;
    try {
      proposalCapsule = proposalStore.
          get(ByteArray.fromLong(contract.getProposalId()));
    } catch (ItemNotFoundException ex) {
      throw new ContractValidateException(PROPOSAL_EXCEPTION_STR + contract.getProposalId()
          + NOT_EXIST_STR);
    }

    long now = dynamicStore.getLatestBlockHeaderTimestamp();
    if (!proposalCapsule.getProposalAddress().equals(contract.getOwnerAddress())) {
      throw new ContractValidateException(PROPOSAL_EXCEPTION_STR + contract.getProposalId() + "] "
          + "is not proposed by " + readableOwnerAddress);
    }
    if (now >= proposalCapsule.getExpirationTime()) {
      throw new ContractValidateException(PROPOSAL_EXCEPTION_STR + contract.getProposalId()
          + "] expired");
    }
    if (proposalCapsule.getState() == State.CANCELED) {
      throw new ContractValidateException(PROPOSAL_EXCEPTION_STR + contract.getProposalId()
          + "] canceled");
    }

    return true;
  }

  @Override
  public ByteString getOwnerAddress() throws InvalidProtocolBufferException {
    return any.unpack(ProposalDeleteContract.class).getOwnerAddress();
  }

  @Override
  public long calcFee() {
    return 0;
  }
}
