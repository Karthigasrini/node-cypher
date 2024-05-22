package org.cypher.core.db2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.cypher.common.application.Application;
import org.cypher.common.application.ApplicationFactory;
import org.cypher.common.application.CypherApplicationContext;
import org.cypher.common.utils.FileUtil;
import org.cypher.core.Constant;
import org.cypher.core.config.DefaultConfig;
import org.cypher.core.config.args.Args;
import org.cypher.core.db.AbstractRevokingStore;
import org.cypher.core.db.RevokingDatabase;
import org.cypher.core.db.CypherStoreWithRevoking;
import org.cypher.core.db2.SnapshotRootTest.ProtoCapsuleTest;
import org.cypher.core.exception.RevokingStoreIllegalStateException;

@Slf4j
public class RevokingDbWithCacheOldValueTest {

  private AbstractRevokingStore revokingDatabase;
  private CypherApplicationContext context;
  private Application appT;

  @Before
  public void init() {
    Args.setParam(new String[]{"-d", "output_revokingStore_test"}, Constant.TEST_CONF);
    context = new CypherApplicationContext(DefaultConfig.class);
    appT = ApplicationFactory.create(context);
    revokingDatabase = new TestRevokingCypherDatabase();
    revokingDatabase.enable();
  }

  @After
  public void removeDb() {
    Args.clearParam();
    context.destroy();
    FileUtil.deleteDir(new File("output_revokingStore_test"));
  }

  @Test
  public synchronized void testReset() {
    revokingDatabase.getStack().clear();
    CypherRevokingCypherStore cypherDatabase = new CypherRevokingCypherStore(
        "cypherrevokingcypherstore-testReset", revokingDatabase);
    ProtoCapsuleTest testProtoCapsule = new ProtoCapsuleTest(("reset").getBytes());
    try (ISession tmpSession = revokingDatabase.buildSession()) {
      cypherDatabase.put(testProtoCapsule.getData(), testProtoCapsule);
      tmpSession.commit();
    }
    Assert.assertTrue(cypherDatabase.has(testProtoCapsule.getData()));
    cypherDatabase.reset();
    Assert.assertFalse(cypherDatabase.has(testProtoCapsule.getData()));
    cypherDatabase.reset();
  }

  @Test
  public synchronized void testPop() throws RevokingStoreIllegalStateException {
    revokingDatabase.getStack().clear();
    CypherRevokingCypherStore cypherDatabase = new CypherRevokingCypherStore(
        "cypherrevokingcypherstore-testPop", revokingDatabase);

    for (int i = 1; i < 11; i++) {
      ProtoCapsuleTest testProtoCapsule = new ProtoCapsuleTest(("pop" + i).getBytes());
      try (ISession tmpSession = revokingDatabase.buildSession()) {
        cypherDatabase.put(testProtoCapsule.getData(), testProtoCapsule);
        Assert.assertEquals(1, revokingDatabase.getActiveDialog());
        tmpSession.commit();
        Assert.assertEquals(i, revokingDatabase.getStack().size());
        Assert.assertEquals(0, revokingDatabase.getActiveDialog());
      }
    }

    for (int i = 1; i < 11; i++) {
      revokingDatabase.pop();
      Assert.assertEquals(10 - i, revokingDatabase.getStack().size());
    }

    cypherDatabase.close();

    Assert.assertEquals(0, revokingDatabase.getStack().size());
  }

  @Test
  public synchronized void testUndo() throws RevokingStoreIllegalStateException {
    revokingDatabase.getStack().clear();
    CypherRevokingCypherStore cypherDatabase = new CypherRevokingCypherStore(
        "cypherrevokingcypherstore-testUndo", revokingDatabase);

    ISession dialog = revokingDatabase.buildSession();
    for (int i = 0; i < 10; i++) {
      ProtoCapsuleTest testProtoCapsule = new ProtoCapsuleTest(("undo" + i).getBytes());
      try (ISession tmpSession = revokingDatabase.buildSession()) {
        cypherDatabase.put(testProtoCapsule.getData(), testProtoCapsule);
        Assert.assertEquals(2, revokingDatabase.getStack().size());
        tmpSession.merge();
        Assert.assertEquals(1, revokingDatabase.getStack().size());
      }
    }

    Assert.assertEquals(1, revokingDatabase.getStack().size());

    dialog.destroy();
    Assert.assertTrue(revokingDatabase.getStack().isEmpty());
    Assert.assertEquals(0, revokingDatabase.getActiveDialog());

    dialog = revokingDatabase.buildSession();
    revokingDatabase.disable();
    ProtoCapsuleTest testProtoCapsule = new ProtoCapsuleTest("del".getBytes());
    cypherDatabase.put(testProtoCapsule.getData(), testProtoCapsule);
    revokingDatabase.enable();

    try (ISession tmpSession = revokingDatabase.buildSession()) {
      cypherDatabase.put(testProtoCapsule.getData(), new ProtoCapsuleTest("del2".getBytes()));
      tmpSession.merge();
    }

    try (ISession tmpSession = revokingDatabase.buildSession()) {
      cypherDatabase.put(testProtoCapsule.getData(), new ProtoCapsuleTest("del22".getBytes()));
      tmpSession.merge();
    }

    try (ISession tmpSession = revokingDatabase.buildSession()) {
      cypherDatabase.put(testProtoCapsule.getData(), new ProtoCapsuleTest("del222".getBytes()));
      tmpSession.merge();
    }

    try (ISession tmpSession = revokingDatabase.buildSession()) {
      cypherDatabase.delete(testProtoCapsule.getData());
      tmpSession.merge();
    }

    dialog.destroy();

    logger.info(
        "**********testProtoCapsule:" + cypherDatabase.getUnchecked(testProtoCapsule.getData())
            .toString());
    Assert.assertArrayEquals("del".getBytes(),
        cypherDatabase.getUnchecked(testProtoCapsule.getData()).getData());
    Assert.assertEquals(testProtoCapsule, cypherDatabase.getUnchecked(testProtoCapsule.getData()));

    cypherDatabase.close();
  }

  @Test
  public synchronized void testGetlatestValues() {
    revokingDatabase.getStack().clear();
    CypherRevokingCypherStore cypherDatabase = new CypherRevokingCypherStore(
        "cypherrevokingcypherstore-testGetlatestValues", revokingDatabase);

    for (int i = 0; i < 10; i++) {
      ProtoCapsuleTest testProtoCapsule = new ProtoCapsuleTest(("getLastestValues" + i).getBytes());
      try (ISession tmpSession = revokingDatabase.buildSession()) {
        cypherDatabase.put(testProtoCapsule.getData(), testProtoCapsule);
        tmpSession.commit();
      }
    }
    Set<ProtoCapsuleTest> result = cypherDatabase.getRevokingDB().getlatestValues(5).stream()
        .map(ProtoCapsuleTest::new)
        .collect(Collectors.toSet());

    for (int i = 9; i >= 5; i--) {
      Assert.assertTrue(result.contains(new ProtoCapsuleTest(("getLastestValues" + i).getBytes())));
    }
    cypherDatabase.close();
  }

  @Test
  public synchronized void testGetValuesNext() {
    revokingDatabase.getStack().clear();
    CypherRevokingCypherStore cypherDatabase = new CypherRevokingCypherStore(
        "cypherrevokingcypherstore-testGetValuesNext", revokingDatabase);

    for (int i = 0; i < 10; i++) {
      ProtoCapsuleTest testProtoCapsule = new ProtoCapsuleTest(("getValuesNext" + i).getBytes());
      try (ISession tmpSession = revokingDatabase.buildSession()) {
        cypherDatabase.put(testProtoCapsule.getData(), testProtoCapsule);
        tmpSession.commit();
      }
    }
    Set<ProtoCapsuleTest> result =
        cypherDatabase.getRevokingDB().getValuesNext(
            new ProtoCapsuleTest("getValuesNext2".getBytes()).getData(), 3)
            .stream()
            .map(ProtoCapsuleTest::new)
            .collect(Collectors.toSet());

    for (int i = 2; i < 5; i++) {
      Assert.assertTrue(result.contains(new ProtoCapsuleTest(("getValuesNext" + i).getBytes())));
    }
    cypherDatabase.close();
  }

  @Test
  public synchronized void testGetKeysNext() {
    revokingDatabase.getStack().clear();
    CypherRevokingCypherStore cypherDatabase = new CypherRevokingCypherStore(
        "cypherrevokingcypherstore-testGetKeysNext", revokingDatabase);

    String protoCapsuleStr = "getKeysNext";
    for (int i = 0; i < 10; i++) {
      ProtoCapsuleTest testProtoCapsule = new ProtoCapsuleTest((protoCapsuleStr + i).getBytes());
      try (ISession tmpSession = revokingDatabase.buildSession()) {
        cypherDatabase.put(testProtoCapsule.getData(), testProtoCapsule);
        tmpSession.commit();
      }
    }

    int start = 2;
    List<byte[]> result =
        cypherDatabase.getRevokingDB().getKeysNext(
            new ProtoCapsuleTest((protoCapsuleStr + start).getBytes()).getData(), 3);

    for (int i = start; i < 5; i++) {
      Assert.assertArrayEquals(new ProtoCapsuleTest((protoCapsuleStr + i).getBytes()).getData(),
          result.get(i - 2));
    }
    cypherDatabase.close();
  }

  @Test
  public void shutdown() throws RevokingStoreIllegalStateException {
    revokingDatabase.getStack().clear();
    CypherRevokingCypherStore cypherDatabase = new CypherRevokingCypherStore(
        "cypherrevokingcypherstore-shutdown", revokingDatabase);

    List<ProtoCapsuleTest> capsules = new ArrayList<>();
    for (int i = 1; i < 11; i++) {
      revokingDatabase.buildSession();
      ProtoCapsuleTest testProtoCapsule = new ProtoCapsuleTest(("test" + i).getBytes());
      capsules.add(testProtoCapsule);
      cypherDatabase.put(testProtoCapsule.getData(), testProtoCapsule);
      Assert.assertEquals(revokingDatabase.getActiveDialog(), i);
      Assert.assertEquals(revokingDatabase.getStack().size(), i);
    }

    for (ProtoCapsuleTest capsule : capsules) {
      logger.info(new String(capsule.getData()));
      Assert.assertEquals(capsule, cypherDatabase.getUnchecked(capsule.getData()));
    }

    revokingDatabase.shutdown();

    for (ProtoCapsuleTest capsule : capsules) {
      logger.info(cypherDatabase.getUnchecked(capsule.getData()).toString());
      Assert.assertEquals(null, cypherDatabase.getUnchecked(capsule.getData()).getData());
    }

    Assert.assertEquals(0, revokingDatabase.getStack().size());
    cypherDatabase.close();

  }

  private static class CypherRevokingCypherStore extends CypherStoreWithRevoking<ProtoCapsuleTest> {

    protected CypherRevokingCypherStore(String dbName, RevokingDatabase revokingDatabase) {
      super(dbName, revokingDatabase);
    }

    @Override
    public ProtoCapsuleTest get(byte[] key) {
      byte[] value = this.revokingDB.getUnchecked(key);
      return ArrayUtils.isEmpty(value) ? null : new ProtoCapsuleTest(value);
    }
  }

  private static class TestRevokingCypherDatabase extends AbstractRevokingStore {

  }
}
