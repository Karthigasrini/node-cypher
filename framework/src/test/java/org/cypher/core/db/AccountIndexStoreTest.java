package org.cypher.core.db;

import com.google.protobuf.ByteString;
import java.io.File;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.cypher.common.application.CypherApplicationContext;
import org.cypher.common.utils.ByteArray;
import org.cypher.common.utils.FileUtil;
import org.cypher.core.Constant;
import org.cypher.core.capsule.AccountCapsule;
import org.cypher.core.config.DefaultConfig;
import org.cypher.core.config.args.Args;
import org.cypher.core.store.AccountIndexStore;
import org.cypher.protos.Protocol.AccountType;

public class AccountIndexStoreTest {

  private static String dbPath = "output_AccountIndexStore_test";
  private static String dbDirectory = "db_AccountIndexStore_test";
  private static String indexDirectory = "index_AccountIndexStore_test";
  private static CypherApplicationContext context;
  private static AccountIndexStore accountIndexStore;
  private static byte[] address = TransactionStoreTest.randomBytes(32);
  private static byte[] accountName = TransactionStoreTest.randomBytes(32);

  static {
    Args.setParam(
        new String[]{
            "--output-directory", dbPath,
            "--storage-db-directory", dbDirectory,
            "--storage-index-directory", indexDirectory
        },
        Constant.TEST_CONF
    );
    context = new CypherApplicationContext(DefaultConfig.class);
  }

  @AfterClass
  public static void destroy() {
    Args.clearParam();
    context.destroy();
    FileUtil.deleteDir(new File(dbPath));
  }

  @BeforeClass
  public static void init() {
    accountIndexStore = context.getBean(AccountIndexStore.class);
    AccountCapsule accountCapsule = new AccountCapsule(ByteString.copyFrom(address),
        ByteString.copyFrom(accountName),
        AccountType.forNumber(1));
    accountIndexStore.put(accountCapsule);
  }

  @Test
  public void get() {
    //test get(ByteString name)
    Assert
        .assertEquals(ByteArray.toHexString(address), ByteArray
            .toHexString(accountIndexStore.get(ByteString.copyFrom(accountName))))
    ;
    //test get(byte[] key)
    Assert
        .assertEquals(ByteArray.toHexString(address), ByteArray
            .toHexString(accountIndexStore.get(accountName).getData()))
    ;
    Assert.assertTrue(accountIndexStore.has(accountName));
  }
}