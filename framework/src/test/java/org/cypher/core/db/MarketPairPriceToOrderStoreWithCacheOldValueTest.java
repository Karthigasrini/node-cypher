package org.cypher.core.db;

import java.io.File;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.iq80.leveldb.Options;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.cypher.common.application.ApplicationFactory;
import org.cypher.common.application.CypherApplicationContext;
import org.cypher.common.utils.ByteArray;
import org.cypher.common.utils.ByteUtil;
import org.cypher.common.utils.FileUtil;
import org.cypher.common.utils.MarketOrderPriceComparatorForLevelDB;
import org.cypher.common.utils.StorageUtils;
import org.cypher.core.Constant;
import org.cypher.core.capsule.MarketOrderIdListCapsule;
import org.cypher.core.capsule.utils.MarketUtils;
import org.cypher.core.config.DefaultConfig;
import org.cypher.core.config.args.Args;
import org.cypher.core.exception.BadItemException;
import org.cypher.core.exception.ItemNotFoundException;

@Slf4j
public class MarketPairPriceToOrderStoreWithCacheOldValueTest {

  private AbstractRevokingStore revokingDatabase;
  private CypherApplicationContext context;

  @Before
  public void init() {
    Args.setParam(new String[]{"-d", "output_market_revokingStore_test"}, Constant.TEST_CONF);
    context = new CypherApplicationContext(DefaultConfig.class);
    ApplicationFactory.create(context);
    revokingDatabase = new TestRevokingCypherDatabase();
    revokingDatabase.enable();
  }

  @After
  public void removeDb() {
    Args.clearParam();
    context.destroy();
    FileUtil.deleteDir(new File("output_market_revokingStore_test"));
  }

  /**
   * Almost the same as testPriceSeqWithSamePair, except using the RevokingDBWithCachingOldValue.
   * We add this test in order to test db.version=1.
   * */
  @Test
  public synchronized void testGetKeysNext() {
    revokingDatabase.getStack().clear();
    String dbName = "cypherrevokingcypherstore-testGetKeysNext";
    Options options = StorageUtils.getOptionsByDbName(dbName);
    options.comparator(new MarketOrderPriceComparatorForLevelDB());
    CypherRevokingCypherStore cypherDatabase = new CypherRevokingCypherStore(dbName, options,
        revokingDatabase);

    // put order: 2 1 3 0
    // lexicographical order: 0 < 3 < 1 = 2
    // key order: 0 < 1 = 2 < 3
    byte[] sellTokenID1 = ByteArray.fromString("100");
    byte[] buyTokenID1 = ByteArray.fromString("200");
    byte[] pairPriceKey0 = MarketUtils.createPairPriceKey(
        sellTokenID1,
        buyTokenID1,
        0L,
        0L
    );
    byte[] pairPriceKey1 = MarketUtils.createPairPriceKey(
        sellTokenID1,
        buyTokenID1,
        10L,
        21L
    );
    byte[] pairPriceKey2 = MarketUtils.createPairPriceKey(
        sellTokenID1,
        buyTokenID1,
        30L,
        63L
    );
    byte[] pairPriceKey3 = MarketUtils.createPairPriceKey(
        sellTokenID1,
        buyTokenID1,
        1L,
        4L
    );

    // lexicographical order: 0 < 3 < 1 = 2
    Assert.assertTrue(ByteUtil.compare(pairPriceKey0, pairPriceKey3) < 0);
    Assert.assertTrue(ByteUtil.compare(pairPriceKey3, pairPriceKey1) < 0);
    Assert.assertEquals(0, ByteUtil.compare(pairPriceKey1, pairPriceKey2));

    MarketOrderIdListCapsule capsule0 = new MarketOrderIdListCapsule(ByteArray.fromLong(0),
        ByteArray.fromLong(0));
    MarketOrderIdListCapsule capsule1 = new MarketOrderIdListCapsule(ByteArray.fromLong(1),
        ByteArray.fromLong(1));
    MarketOrderIdListCapsule capsule2 = new MarketOrderIdListCapsule(ByteArray.fromLong(2),
        ByteArray.fromLong(2));
    MarketOrderIdListCapsule capsule3 = new MarketOrderIdListCapsule(ByteArray.fromLong(3),
        ByteArray.fromLong(3));

    // put: 2 1 0 3
    Assert.assertFalse(cypherDatabase.has(pairPriceKey2));
    cypherDatabase.put(pairPriceKey2, capsule2);

    try {
      Assert
          .assertArrayEquals(capsule2.getData(),
              cypherDatabase.get(pairPriceKey2).getData());
    } catch (ItemNotFoundException | BadItemException e) {
      Assert.fail();
    }

    // pairPriceKey1 and pairPriceKey2 has the same value,
    // After put pairPriceKey2, pairPriceKey2 will be replaced by pairPriceKey1, both key and value.
    // But you can still get(pairPriceKey2) return pairPriceKey1's value
    Assert.assertTrue(cypherDatabase.has(pairPriceKey1));
    cypherDatabase.put(pairPriceKey1, capsule1);
    Assert.assertEquals(1, cypherDatabase.size());

    try {
      Assert
          .assertArrayEquals(capsule1.getData(),
              cypherDatabase.get(pairPriceKey1).getData());
      Assert
          .assertArrayEquals(capsule1.getData(),
              cypherDatabase.get(pairPriceKey2).getData());
    } catch (ItemNotFoundException | BadItemException e) {
      Assert.fail();
    }

    Assert.assertFalse(cypherDatabase.has(pairPriceKey0));
    if (!cypherDatabase.has(pairPriceKey0)) {
      cypherDatabase.put(pairPriceKey0, capsule0);
    }

    Assert.assertEquals(2, cypherDatabase.size());

    Assert.assertFalse(cypherDatabase.has(pairPriceKey3));
    if (!cypherDatabase.has(pairPriceKey3)) {
      cypherDatabase.put(pairPriceKey3, capsule3);
    }

    Assert.assertEquals(3, cypherDatabase.size());

    // get pairPriceKey1, will get pairPriceKey2's value capsule2
    try {
      Assert
          .assertArrayEquals(capsule0.getData(),
              cypherDatabase.get(pairPriceKey0).getData());
      Assert
          .assertArrayEquals(capsule1.getData(),
              cypherDatabase.get(pairPriceKey1).getData());
      Assert
          .assertArrayEquals(capsule1.getData(),
              cypherDatabase.get(pairPriceKey2).getData());
      Assert
          .assertArrayEquals(capsule3.getData(),
              cypherDatabase.get(pairPriceKey3).getData());
    } catch (ItemNotFoundException | BadItemException e) {
      Assert.fail();
    }

    List<byte[]> keyList = cypherDatabase.getRevokingDB().getKeysNext(pairPriceKey0, 2 + 1);
    Assert.assertArrayEquals(pairPriceKey0, keyList.get(0));
    Assert.assertArrayEquals(pairPriceKey1, keyList.get(1));
    Assert.assertArrayEquals(pairPriceKey3, keyList.get(2));


    cypherDatabase.close();
  }

  private static class CypherRevokingCypherStore extends
      CypherStoreWithRevoking<MarketOrderIdListCapsule> {

    private CypherRevokingCypherStore(String dbName, Options options,
        RevokingDatabase revokingDatabase) {
      super(dbName, options, revokingDatabase);
    }
  }

  private static class TestRevokingCypherDatabase extends AbstractRevokingStore {

  }
}
