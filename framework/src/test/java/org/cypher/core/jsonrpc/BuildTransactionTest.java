package org.cypher.core.jsonrpc;

import com.google.protobuf.ByteString;
import java.io.File;
import lombok.extern.slf4j.Slf4j;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.cypher.common.application.CypherApplicationContext;
import org.cypher.common.utils.ByteArray;
import org.cypher.common.utils.FileUtil;
import org.cypher.core.Constant;
import org.cypher.core.Wallet;
import org.cypher.core.capsule.AccountCapsule;
import org.cypher.core.capsule.ContractCapsule;
import org.cypher.core.config.DefaultConfig;
import org.cypher.core.config.args.Args;
import org.cypher.core.db.Manager;
import org.cypher.core.services.jsonrpc.types.BuildArguments;
import org.cypher.protos.Protocol;
import org.cypher.protos.Protocol.Transaction.Contract.ContractType;
import org.cypher.protos.contract.SmartContractOuterClass.SmartContract;

@Slf4j
public class BuildTransactionTest {

  private static String dbPath = "output_build_transaction_test";
  private static final String OWNER_ADDRESS;
  private static final String OWNER_ADDRESS_ACCOUNT_NAME = "first";

  private static final String SMART_CONTRACT_NAME = "smart_contarct";
  private static final String CONTRACT_ADDRESS;
  private static final long SOURCE_PERCENT = 10L;

  private static CypherApplicationContext context;
  private static Manager dbManager;
  private static Wallet wallet;

  static {
    Args.setParam(new String[]{"--output-directory", dbPath}, Constant.TEST_CONF);
    context = new CypherApplicationContext(DefaultConfig.class);

    OWNER_ADDRESS =
        Wallet.getAddressPreFixString() + "abd4b9367799eaa3197fecb144eb71de1e049abc";
    CONTRACT_ADDRESS = Wallet.getAddressPreFixString() + "f859b5c93f789f4bcffbe7cc95a71e28e5e6a5bd";
  }

  @BeforeClass
  public static void init() {
    dbManager = context.getBean(Manager.class);
    wallet = context.getBean(Wallet.class);

    AccountCapsule accountCapsule =
        new AccountCapsule(
            ByteString.copyFrom(ByteArray.fromHexString(OWNER_ADDRESS)),
            ByteString.copyFromUtf8(OWNER_ADDRESS_ACCOUNT_NAME),
            Protocol.AccountType.Normal);
    dbManager.getAccountStore().put(accountCapsule.getAddress().toByteArray(), accountCapsule);

    AccountCapsule contractCapsule =
        new AccountCapsule(
            ByteString.copyFrom(ByteArray.fromHexString(CONTRACT_ADDRESS)),
            ByteString.copyFromUtf8(OWNER_ADDRESS_ACCOUNT_NAME),
            Protocol.AccountType.Normal);
    dbManager.getAccountStore().put(contractCapsule.getAddress().toByteArray(), contractCapsule);

    // smartContarct in contractStore
    SmartContract.Builder builder = SmartContract.newBuilder();
    builder.setName(SMART_CONTRACT_NAME);
    builder.setOriginAddress(ByteString.copyFrom(ByteArray.fromHexString(OWNER_ADDRESS)));
    builder.setContractAddress(ByteString.copyFrom(ByteArray.fromHexString(CONTRACT_ADDRESS)));
    builder.setConsumeUserResourcePercent(SOURCE_PERCENT);
    dbManager.getContractStore().put(
        contractCapsule.getAddress().toByteArray(),
        new ContractCapsule(builder.build()));
  }

  @AfterClass
  public static void removeDb() {
    Args.clearParam();
    context.destroy();
    if (FileUtil.deleteDir(new File(dbPath))) {
      logger.info("Release resources successful.");
    } else {
      logger.info("Release resources failure.");
    }
  }

  @Test
  public void testTransferContract() {
    BuildArguments buildArguments = new BuildArguments();
    buildArguments.from = "0xabd4b9367799eaa3197fecb144eb71de1e049abc";
    buildArguments.to = "0x548794500882809695a8a687866e76d4271a1abc";
    buildArguments.value = "0x1f4";

    try {
      ContractType contractType = buildArguments.getContractType(wallet);
      Assert.assertEquals(ContractType.TransferContract, contractType);
    } catch (Exception e) {
      Assert.fail();
    }
  }

  @Test
  public void testTransferAssertContract() {
    BuildArguments buildArguments = new BuildArguments();
    buildArguments.from = "0xabd4b9367799eaa3197fecb144eb71de1e049abc";
    buildArguments.to = "0x548794500882809695a8a687866e76d4271a1abc";
    buildArguments.tokenId = 1000016L;
    buildArguments.tokenValue = 20L;

    try {
      ContractType contractType = buildArguments.getContractType(wallet);
      Assert.assertEquals(ContractType.TransferAssetContract, contractType);
    } catch (Exception e) {
      Assert.fail();
    }
  }

  @Test
  public void testCreateSmartContract() {
    BuildArguments buildArguments = new BuildArguments();
    buildArguments.from = "0xabd4b9367799eaa3197fecb144eb71de1e049abc";
    buildArguments.name = "transferTokenContract";
    buildArguments.gas = "0x245498";
    buildArguments.abi =
        "[{\"constant\":false,\"inputs\":[],\"name\":\"getResultInCon\",\"outputs\":"
            + "[{\"name\":\"\",\"type\":\"trcToken\"},{\"name\":\"\",\"type\":\"uint256\"},"
            + "{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":true,"
            + "\"stateMutability\":\"payable\",\"type\":\"function\"},"
            + "{\"constant\":false,\"inputs\":[{\"name\":\"toAddress\",\"type\":\"address\"},"
            + "{\"name\":\"id\",\"type\":\"trcToken\"},{\"name\":\"amount\",\"type\":\"uint256\"}],"
            + "\"name\":\"TransferTokenTo\",\"outputs\":[],\"payable\":true,"
            + "\"stateMutability\":\"payable\",\"type\":\"function\"},"
            + "{\"constant\":false,\"inputs\":[],\"name\":\"msgTokenValueAndTokenIdTest\","
            + "\"outputs\":[{\"name\":\"\",\"type\":\"trcToken\"},"
            + "{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"uint256\"}],"
            + "\"payable\":true,\"stateMutability\":\"payable\",\"type\":\"function\"},"
            + "{\"inputs\":[],\"payable\":true,\"stateMutability\":\"payable\","
            + "\"type\":\"constructor\"}]\n";
    buildArguments.data =
        "6080604052d3600055d2600155346002556101418061001f6000396000f30060806040526004361061005657"
            + "63ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166305"
            + "c24200811461005b5780633be9ece71461008157806371dc08ce146100aa575b600080fd5b610063610"
            + "0b2565b60408051938452602084019290925282820152519081900360600190f35b6100a873fffffff"
            + "fffffffffffffffffffffffffffffffff600435166024356044356100c0565b005b61006361010d565"
            + "b600054600154600254909192565b60405173ffffffffffffffffffffffffffffffffffffffff84169"
            + "082156108fc029083908590600081818185878a8ad0945050505050158015610107573d6000803e3d6"
            + "000fd5b50505050565bd3d2349091925600a165627a7a72305820a2fb39541e90eda9a2f5f9e7905ef"
            + "98e66e60dd4b38e00b05de418da3154e7570029";
    buildArguments.consumeUserResourcePercent = 100L;
    buildArguments.originEnergyLimit = 11111111111111L;
    buildArguments.value = "0x1f4";
    buildArguments.tokenId = 1000033L;
    buildArguments.tokenValue = 100000L;

    try {
      ContractType contractType = buildArguments.getContractType(wallet);
      Assert.assertEquals(ContractType.CreateSmartContract, contractType);
    } catch (Exception e) {
      Assert.fail();
    }
  }

  @Test
  public void testTriggerSmartContract() {
    BuildArguments buildArguments = new BuildArguments();
    buildArguments.from = "0xabd4b9367799eaa3197fecb144eb71de1e049abc";
    buildArguments.to = "0x" + CONTRACT_ADDRESS;
    buildArguments.data =
        "0x3be9ece7000000000000000000000000ba8e28bdb6e49fbb3f5cd82a9f5ce8363587f1f6000000000000000"
            + "00000000000000000000000000000000000000000000f42630000000000000000000000000000000000"
            + "000000000000000000000000000001";
    buildArguments.gas = "0x245498";
    buildArguments.value = "0xA";
    buildArguments.tokenId = 1000035L;
    buildArguments.tokenValue = 20L;

    try {
      ContractType contractType = buildArguments.getContractType(wallet);
      Assert.assertEquals(ContractType.TriggerSmartContract, contractType);
    } catch (Exception e) {
      Assert.fail();
    }
  }

  @Test
  public void testNoToNoData() {
    BuildArguments buildArguments = new BuildArguments();
    buildArguments.from = "0xabd4b9367799eaa3197fecb144eb71de1e049abc";
    buildArguments.to = "0x548794500882809695a8a687866e76d4271a1abc";

    try {
      ContractType contractType = buildArguments.getContractType(wallet);
      Assert.assertEquals(ContractType.TriggerSmartContract, contractType);
    } catch (Exception e) {
      Assert.assertEquals("invalid json request", e.getMessage());
    }
  }
}