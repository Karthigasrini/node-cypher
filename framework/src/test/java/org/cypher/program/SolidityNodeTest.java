package org.cypher.program;

import java.io.File;
import lombok.extern.slf4j.Slf4j;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.cypher.common.application.Application;
import org.cypher.common.application.ApplicationFactory;
import org.cypher.common.application.CypherApplicationContext;
import org.cypher.common.overlay.client.DatabaseGrpcClient;
import org.cypher.core.Constant;
import org.cypher.core.config.DefaultConfig;
import org.cypher.core.config.args.Args;
import org.cypher.core.services.RpcApiService;
import org.cypher.protos.Protocol.Block;
import org.cypher.protos.Protocol.DynamicProperties;

@Slf4j
public class SolidityNodeTest {

  private static CypherApplicationContext context;

  private static RpcApiService rpcApiService;
  private static Application appT;
  private static String dbPath = "output_witness_test";

  static {
    Args.setParam(new String[]{"-d", dbPath}, Constant.TEST_CONF);
    context = new CypherApplicationContext(DefaultConfig.class);
    Args.getInstance().setSolidityNode(true);
    appT = ApplicationFactory.create(context);
    rpcApiService = context.getBean(RpcApiService.class);
  }

  /**
   * init db.
   */
  @BeforeClass
  public static void init() {
    rpcApiService.start();
  }

  /**
   * remo db when after test.
   */
  @AfterClass
  public static void removeDb() {
    Args.clearParam();
    rpcApiService.stop();
    context.destroy();
    File dbFolder = new File(dbPath);
    if (deleteFolder(dbFolder)) {
      logger.info("Release resources successful.");
    } else {
      logger.info("Release resources failure.");
    }
  }

  private static Boolean deleteFolder(File index) {
    if (!index.isDirectory() || index.listFiles().length <= 0) {
      return index.delete();
    }
    for (File file : index.listFiles()) {
      if (null != file && !deleteFolder(file)) {
        return false;
      }
    }
    return index.delete();
  }

  @Test
  public void testSolidityArgs() {
    Assert.assertNotNull(Args.getInstance().getTrustNodeAddr());
    Assert.assertTrue(Args.getInstance().isSolidityNode());
  }

  @Test
  public void testSolidityGrpcCall() {
    DatabaseGrpcClient databaseGrpcClient = null;
    String addr = Args.getInstance().getTrustNodeAddr();
    try {
      databaseGrpcClient = new DatabaseGrpcClient(addr);
    } catch (Exception e) {
      logger.error("Failed to create database grpc client {}", addr);
    }

    Assert.assertNotNull(databaseGrpcClient);
    DynamicProperties dynamicProperties = databaseGrpcClient.getDynamicProperties();
    Assert.assertNotNull(dynamicProperties);

    Block genesisBlock = databaseGrpcClient.getBlock(0);
    Assert.assertNotNull(genesisBlock);
    Assert.assertFalse(genesisBlock.getTransactionsList().isEmpty());
  }

}
