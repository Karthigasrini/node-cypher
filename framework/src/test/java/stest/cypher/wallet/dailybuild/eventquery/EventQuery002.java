package stest.cypher.wallet.dailybuild.eventquery;

import com.alibaba.fastjson.JSONObject;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.cypher.api.WalletGrpc;
import org.cypher.common.crypto.ECKey;
import org.cypher.common.utils.ByteArray;
import org.cypher.common.utils.Utils;
import org.cypher.core.Wallet;
import org.zeromq.ZMQ;
import stest.cypher.wallet.common.client.Configuration;
import stest.cypher.wallet.common.client.Parameter.CommonConstant;
import stest.cypher.wallet.common.client.utils.PublicMethed;
import zmq.ZMQ.Event;

@Slf4j
public class EventQuery002 {

  private final String testKey002 = Configuration.getByPath("testng.conf")
      .getString("foundationAccount.key1");
  private final byte[] fromAddress = PublicMethed.getFinalAddress(testKey002);
  private final String testKey003 = Configuration.getByPath("testng.conf")
      .getString("foundationAccount.key2");
  private final byte[] toAddress = PublicMethed.getFinalAddress(testKey003);
  private ManagedChannel channelFull = null;
  private WalletGrpc.WalletBlockingStub blockingStubFull = null;
  private String fullnode = Configuration.getByPath("testng.conf")
      .getStringList("fullnode.ip.list").get(0);
  private String eventnode = Configuration.getByPath("testng.conf")
      .getStringList("eventnode.ip.list").get(0);
  private Long maxFeeLimit = Configuration.getByPath("testng.conf")
      .getLong("defaultParameter.maxFeeLimit");
  byte[] contractAddress;
  String txid;

  ECKey ecKey1 = new ECKey(Utils.getRandom());
  byte[] event001Address = ecKey1.getAddress();
  String event001Key = ByteArray.toHexString(ecKey1.getPrivKeyBytes());

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

    ecKey1 = new ECKey(Utils.getRandom());
    event001Address = ecKey1.getAddress();
    event001Key = ByteArray.toHexString(ecKey1.getPrivKeyBytes());
    PublicMethed.printAddress(event001Key);

    Assert.assertTrue(PublicMethed.sendcoin(event001Address, maxFeeLimit * 30, fromAddress,
        testKey002, blockingStubFull));
    PublicMethed.waitProduceNextBlock(blockingStubFull);

    String contractName = "addressDemo";
    String code = Configuration.getByPath("testng.conf")
        .getString("code.code_ContractEventAndLog1");
    String abi = Configuration.getByPath("testng.conf")
        .getString("abi.abi_ContractEventAndLog1");
    contractAddress = PublicMethed.deployContract(contractName, abi, code, "", maxFeeLimit,
        0L, 50, null, event001Key, event001Address, blockingStubFull);
    PublicMethed.waitProduceNextBlock(blockingStubFull);


  }

  @Test(enabled = true, description = "Event query for transaction")
  public void test01EventQueryForTransaction() {
    ZMQ.Context context = ZMQ.context(1);
    ZMQ.Socket req = context.socket(ZMQ.SUB);

    req.subscribe("transactionTrigger");
    final ZMQ.Socket moniter = context.socket(ZMQ.PAIR);
    moniter.connect("inproc://reqmoniter");
    new Thread(new Runnable() {
      public void run() {
        while (true) {
          Event event = Event.read(moniter.base());
          System.out.println(event.event + "  " + event.addr);
        }
      }

    }).start();
    req.connect(eventnode);
    req.setReceiveTimeOut(10000);
    String transactionMessage = "";
    Boolean sendTransaction = true;
    Integer retryTimes = 20;

    while (retryTimes-- > 0) {
      byte[] message = req.recv();
      if (sendTransaction) {
        txid = PublicMethed.triggerContract(contractAddress,
            "triggerUintEvent()", "#", false,
            0, maxFeeLimit, event001Address, event001Key, blockingStubFull);
        logger.info(txid);
        if (PublicMethed.getTransactionInfoById(txid,blockingStubFull).get()
            .getResultValue() == 0) {
          sendTransaction = false;
        }
      }

      if (message != null) {
        transactionMessage = new String(message);
        if (!transactionMessage.equals("transactionTrigger") && !transactionMessage.isEmpty()) {
          break;
        }
      }
    }

    Assert.assertTrue(retryTimes > 0);
    logger.info("transaction message:" + transactionMessage);
    JSONObject blockObject = JSONObject.parseObject(transactionMessage);
    Assert.assertTrue(blockObject.containsKey("timeStamp"));
    Assert.assertEquals(blockObject.getString("triggerName"), "transactionTrigger");

    Assert.assertEquals(blockObject.getString("transactionId"), txid);
  }

  /**
   * constructor.
   */

  @AfterClass
  public void shutdown() throws InterruptedException {
    if (channelFull != null) {
      channelFull.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
  }
}


