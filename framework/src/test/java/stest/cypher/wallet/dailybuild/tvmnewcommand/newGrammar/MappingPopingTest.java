package stest.cypher.wallet.dailybuild.tvmnewcommand.newGrammar;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.cypher.api.GrpcAPI.AccountResourceMessage;
import org.cypher.api.WalletGrpc;
import org.cypher.common.crypto.ECKey;
import org.cypher.common.utils.ByteArray;
import org.cypher.common.utils.Utils;
import org.cypher.core.Wallet;
import org.cypher.protos.Protocol;
import org.cypher.protos.Protocol.TransactionInfo;
import org.cypher.protos.contract.SmartContractOuterClass.SmartContract;
import stest.cypher.wallet.common.client.Configuration;
import stest.cypher.wallet.common.client.Parameter.CommonConstant;
import stest.cypher.wallet.common.client.utils.PublicMethed;

@Slf4j
public class MappingPopingTest {

  private final String testKey002 = Configuration.getByPath("testng.conf")
      .getString("foundationAccount.key2");
  private final byte[] fromAddress = PublicMethed.getFinalAddress(testKey002);

  private ManagedChannel channelFull = null;
  private WalletGrpc.WalletBlockingStub blockingStubFull = null;
  private String fullnode = Configuration.getByPath("testng.conf")
      .getStringList("fullnode.ip.list").get(1);
  private long maxFeeLimit = Configuration.getByPath("testng.conf")
      .getLong("defaultParameter.maxFeeLimit");

  private byte[] contractAddress = null;

  private ECKey ecKey1 = new ECKey(Utils.getRandom());
  private byte[] dev001Address = ecKey1.getAddress();
  private String dev001Key = ByteArray.toHexString(ecKey1.getPrivKeyBytes());

  @BeforeSuite
  public void beforeSuite() {
    Wallet wallet = new Wallet();
    Wallet.setAddressPreFixByte(CommonConstant.ADD_PRE_FIX_BYTE_MAINNET);
  }

  /**
   * constructor.
   */
  @BeforeClass(enabled = true)
  public void beforeClass() {

    channelFull = ManagedChannelBuilder.forTarget(fullnode)
        .usePlaintext(true)
        .build();
    blockingStubFull = WalletGrpc.newBlockingStub(channelFull);

    PublicMethed.printAddress(dev001Key);
  }

  @Test(enabled = true, description = "Deploy contract")
  public void test01DeployContract() {
    Assert.assertTrue(PublicMethed.sendcoin(dev001Address, 1000_000_000L, fromAddress,
        testKey002, blockingStubFull));
    PublicMethed.waitProduceNextBlock(blockingStubFull);

    //before deploy, check account resource
    AccountResourceMessage accountResource = PublicMethed.getAccountResource(dev001Address,
        blockingStubFull);
    Protocol.Account info = PublicMethed.queryAccount(dev001Key, blockingStubFull);
    Long beforeBalance = info.getBalance();
    Long beforeEnergyUsed = accountResource.getEnergyUsed();
    Long beforeNetUsed = accountResource.getNetUsed();
    Long beforeFreeNetUsed = accountResource.getFreeNetUsed();
    logger.info("beforeBalance:" + beforeBalance);
    logger.info("beforeEnergyUsed:" + beforeEnergyUsed);
    logger.info("beforeNetUsed:" + beforeNetUsed);
    logger.info("beforeFreeNetUsed:" + beforeFreeNetUsed);

    String filePath = "./src/test/resources/soliditycode/TestMappings_array_pop.sol";
    String contractName = "C";
    HashMap retMap = PublicMethed.getBycodeAbi(filePath, contractName);
    String code = retMap.get("byteCode").toString();
    String abi = retMap.get("abI").toString();

    final String txid = PublicMethed
        .deployContractAndGetTransactionInfoById(contractName, abi, code, "",
            maxFeeLimit, 0L, 0, 10000,
            "0", 0, null, dev001Key,
            dev001Address, blockingStubFull);
    PublicMethed.waitProduceNextBlock(blockingStubFull);

    Optional<TransactionInfo> infoById = null;
    PublicMethed.waitProduceNextBlock(blockingStubFull);
    infoById = PublicMethed.getTransactionInfoById(txid, blockingStubFull);
    if (infoById.get().getResultValue() != 0) {
      Assert.fail("deploy transaction failed with message: " + infoById.get().getResMessage());
    }

    TransactionInfo transactionInfo = infoById.get();
    logger.info("EnergyUsageTotal: " + transactionInfo.getReceipt().getEnergyUsageTotal());
    logger.info("NetUsage: " + transactionInfo.getReceipt().getNetUsage());

    contractAddress = infoById.get().getContractAddress().toByteArray();
    SmartContract smartContract = PublicMethed.getContract(contractAddress,
        blockingStubFull);
    Assert.assertNotNull(smartContract.getAbi());

    Long fee = infoById.get().getFee();
    Long netUsed = infoById.get().getReceipt().getNetUsage();
    Long energyUsed = infoById.get().getReceipt().getEnergyUsage();
    Long netFee = infoById.get().getReceipt().getNetFee();
    long energyUsageTotal = infoById.get().getReceipt().getEnergyUsageTotal();
    logger.info("fee:" + fee);
    logger.info("netUsed:" + netUsed);
    logger.info("energyUsed:" + energyUsed);
    logger.info("netFee:" + netFee);
    logger.info("energyUsageTotal:" + energyUsageTotal);

    Protocol.Account infoafter = PublicMethed.queryAccount(dev001Key, blockingStubFull);
    AccountResourceMessage resourceInfoafter = PublicMethed
        .getAccountResource(dev001Address,
            blockingStubFull);
    Long afterBalance = infoafter.getBalance();
    Long afterEnergyUsed = resourceInfoafter.getEnergyUsed();
    Long afterNetUsed = resourceInfoafter.getNetUsed();
    Long afterFreeNetUsed = resourceInfoafter.getFreeNetUsed();
    logger.info("afterBalance:" + afterBalance);
    logger.info("afterEnergyUsed:" + afterEnergyUsed);
    logger.info("afterNetUsed:" + afterNetUsed);
    logger.info("afterFreeNetUsed:" + afterFreeNetUsed);

    Assert.assertTrue(afterBalance + fee == beforeBalance);
    Assert.assertTrue(beforeEnergyUsed + energyUsed >= afterEnergyUsed);
    Assert.assertTrue(beforeFreeNetUsed + netUsed >= afterFreeNetUsed);
    Assert.assertTrue(beforeNetUsed + netUsed >= afterNetUsed);
  }

  @Test(enabled = true, description = "Trigger contract ")
  public void test02TriggerContract() {
    String methodStr = "n1(uint256,uint256)";
    String argStr = "1,1001";
    String txid = PublicMethed.triggerContract(contractAddress, methodStr, argStr, false,
        0, maxFeeLimit, dev001Address, dev001Key, blockingStubFull);
    PublicMethed.waitProduceNextBlock(blockingStubFull);
    Optional<TransactionInfo> infoById = PublicMethed
        .getTransactionInfoById(txid, blockingStubFull);
    if (infoById.get().getResultValue() != 0) {
      Assert.fail("trigger contract failed with message: " + infoById.get().getResMessage());
    }
    logger.info("infoById" + infoById);
  }

  @Test(enabled = true, description = "Trigger contract ")
  public void test03TriggerContract() {
    String methodStr = "p()";
    String argStr = "";
    String txid = PublicMethed.triggerContract(contractAddress, methodStr, argStr, false,
        0, maxFeeLimit, dev001Address, dev001Key, blockingStubFull);
    PublicMethed.waitProduceNextBlock(blockingStubFull);
    Optional<TransactionInfo> infoById = PublicMethed
        .getTransactionInfoById(txid, blockingStubFull);
    if (infoById.get().getResultValue() != 0) {
      Assert.fail("trigger contract failed with message: " + infoById.get().getResMessage());
    }
    logger.info("infoById" + infoById);
  }

  /**
   * constructor.
   */
  @AfterClass
  public void shutdown() throws InterruptedException {
    long balance = PublicMethed.queryAccount(dev001Key, blockingStubFull).getBalance();
    PublicMethed.sendcoin(fromAddress, balance, dev001Address, dev001Key,
        blockingStubFull);
    if (channelFull != null) {
      channelFull.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
  }
}
