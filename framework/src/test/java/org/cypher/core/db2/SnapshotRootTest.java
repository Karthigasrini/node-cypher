package org.cypher.core.db2;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.cypher.common.application.Application;
import org.cypher.common.application.ApplicationFactory;
import org.cypher.common.application.CypherApplicationContext;
import org.cypher.common.utils.FileUtil;
import org.cypher.common.utils.SessionOptional;
import org.cypher.core.Constant;
import org.cypher.core.capsule.ProtoCapsule;
import org.cypher.core.config.DefaultConfig;
import org.cypher.core.config.args.Args;
import org.cypher.core.db2.RevokingDbWithCacheNewValueTest.CypherRevokingCypherStore;
import org.cypher.core.db2.core.Snapshot;
import org.cypher.core.db2.core.SnapshotManager;
import org.cypher.core.db2.core.SnapshotRoot;

public class SnapshotRootTest {

  private CypherRevokingCypherStore cypherDatabase;
  private CypherApplicationContext context;
  private Application appT;
  private SnapshotManager revokingDatabase;

  @Before
  public void init() {
    Args.setParam(new String[]{"-d", "output_revokingStore_test"}, Constant.TEST_CONF);
    context = new CypherApplicationContext(DefaultConfig.class);
    appT = ApplicationFactory.create(context);
  }

  @After
  public void removeDb() {
    Args.clearParam();
    context.destroy();
    FileUtil.deleteDir(new File("output_revokingStore_test"));
  }

  @Test
  public synchronized void testRemove() {
    ProtoCapsuleTest testProtoCapsule = new ProtoCapsuleTest("test".getBytes());
    cypherDatabase = new CypherRevokingCypherStore("testSnapshotRoot-testRemove");
    cypherDatabase.put("test".getBytes(), testProtoCapsule);
    Assert.assertEquals(testProtoCapsule, cypherDatabase.get("test".getBytes()));

    cypherDatabase.delete("test".getBytes());
    Assert.assertEquals(null, cypherDatabase.get("test".getBytes()));
    cypherDatabase.close();
  }

  @Test
  public synchronized void testMerge() {
    cypherDatabase = new CypherRevokingCypherStore("testSnapshotRoot-testMerge");
    revokingDatabase = context.getBean(SnapshotManager.class);
    revokingDatabase.enable();
    revokingDatabase.add(cypherDatabase.getRevokingDB());

    SessionOptional dialog = SessionOptional.instance().setValue(revokingDatabase.buildSession());
    ProtoCapsuleTest testProtoCapsule = new ProtoCapsuleTest("merge".getBytes());
    cypherDatabase.put(testProtoCapsule.getData(), testProtoCapsule);
    revokingDatabase.getDbs().forEach(db -> db.getHead().getRoot().merge(db.getHead()));
    dialog.reset();
    Assert.assertEquals(cypherDatabase.get(testProtoCapsule.getData()), testProtoCapsule);

    cypherDatabase.close();
  }

  @Test
  public synchronized void testMergeList() {
    cypherDatabase = new CypherRevokingCypherStore("testSnapshotRoot-testMergeList");
    revokingDatabase = context.getBean(SnapshotManager.class);
    revokingDatabase.enable();
    revokingDatabase.add(cypherDatabase.getRevokingDB());

    SessionOptional.instance().setValue(revokingDatabase.buildSession());
    ProtoCapsuleTest testProtoCapsule = new ProtoCapsuleTest("test".getBytes());
    cypherDatabase.put("merge".getBytes(), testProtoCapsule);
    for (int i = 1; i < 11; i++) {
      ProtoCapsuleTest tmpProtoCapsule = new ProtoCapsuleTest(("mergeList" + i).getBytes());
      try (ISession tmpSession = revokingDatabase.buildSession()) {
        cypherDatabase.put(tmpProtoCapsule.getData(), tmpProtoCapsule);
        tmpSession.commit();
      }
    }
    revokingDatabase.getDbs().forEach(db -> {
      List<Snapshot> snapshots = new ArrayList<>();
      SnapshotRoot root = (SnapshotRoot) db.getHead().getRoot();
      Snapshot next = root;
      for (int i = 0; i < 11; ++i) {
        next = next.getNext();
        snapshots.add(next);
      }
      root.merge(snapshots);
      root.resetSolidity();

      for (int i = 1; i < 11; i++) {
        ProtoCapsuleTest tmpProtoCapsule = new ProtoCapsuleTest(("mergeList" + i).getBytes());
        Assert.assertEquals(tmpProtoCapsule, cypherDatabase.get(tmpProtoCapsule.getData()));
      }

    });
    revokingDatabase.updateSolidity(10);
    cypherDatabase.close();
  }

  @NoArgsConstructor
  @AllArgsConstructor
  @EqualsAndHashCode
  public static class ProtoCapsuleTest implements ProtoCapsule<Object> {

    private byte[] value;

    @Override
    public byte[] getData() {
      return value;
    }

    @Override
    public Object getInstance() {
      return value;
    }

    @Override
    public String toString() {
      return "ProtoCapsuleTest{"
          + "value=" + Arrays.toString(value)
          + ", string=" + (value == null ? "" : new String(value))
          + '}';
    }
  }
}
