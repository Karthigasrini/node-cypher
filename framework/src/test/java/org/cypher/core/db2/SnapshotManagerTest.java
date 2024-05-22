package org.cypher.core.db2;

import java.io.File;
import lombok.extern.slf4j.Slf4j;
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
import org.cypher.core.db2.RevokingDbWithCacheNewValueTest.CypherRevokingCypherStore;
import org.cypher.core.db2.SnapshotRootTest.ProtoCapsuleTest;
import org.cypher.core.db2.core.SnapshotManager;
import org.cypher.core.exception.BadItemException;
import org.cypher.core.exception.ItemNotFoundException;

@Slf4j
public class SnapshotManagerTest {

  private SnapshotManager revokingDatabase;
  private CypherApplicationContext context;
  private Application appT;
  private CypherRevokingCypherStore cypherDatabase;

  @Before
  public void init() {
    Args.setParam(new String[]{"-d", "output_SnapshotManager_test"},
        Constant.TEST_CONF);
    context = new CypherApplicationContext(DefaultConfig.class);
    appT = ApplicationFactory.create(context);
    revokingDatabase = context.getBean(SnapshotManager.class);
    revokingDatabase.enable();
    cypherDatabase = new CypherRevokingCypherStore("testSnapshotManager-test");
    revokingDatabase.add(cypherDatabase.getRevokingDB());
  }

  @After
  public void removeDb() {
    Args.clearParam();
    context.destroy();
    cypherDatabase.close();
    FileUtil.deleteDir(new File("output_SnapshotManager_test"));
    revokingDatabase.getCheckTmpStore().close();
    cypherDatabase.close();
  }

  @Test
  public synchronized void testRefresh()
      throws BadItemException, ItemNotFoundException {
    while (revokingDatabase.size() != 0) {
      revokingDatabase.pop();
    }

    revokingDatabase.setMaxFlushCount(0);
    revokingDatabase.setUnChecked(false);
    revokingDatabase.setMaxSize(5);
    ProtoCapsuleTest protoCapsule = new ProtoCapsuleTest("refresh".getBytes());
    for (int i = 1; i < 11; i++) {
      ProtoCapsuleTest testProtoCapsule = new ProtoCapsuleTest(("refresh" + i).getBytes());
      try (ISession tmpSession = revokingDatabase.buildSession()) {
        cypherDatabase.put(protoCapsule.getData(), testProtoCapsule);
        tmpSession.commit();
      }
    }

    revokingDatabase.flush();
    Assert.assertEquals(new ProtoCapsuleTest("refresh10".getBytes()),
        cypherDatabase.get(protoCapsule.getData()));
  }

  @Test
  public synchronized void testClose() {
    while (revokingDatabase.size() != 0) {
      revokingDatabase.pop();
    }

    revokingDatabase.setMaxFlushCount(0);
    revokingDatabase.setUnChecked(false);
    revokingDatabase.setMaxSize(5);
    ProtoCapsuleTest protoCapsule = new ProtoCapsuleTest("close".getBytes());
    for (int i = 1; i < 11; i++) {
      ProtoCapsuleTest testProtoCapsule = new ProtoCapsuleTest(("close" + i).getBytes());
      try (ISession tmpSession = revokingDatabase.buildSession()) {
        cypherDatabase.put(protoCapsule.getData(), testProtoCapsule);
      }
    }
    Assert.assertEquals(null,
        cypherDatabase.get(protoCapsule.getData()));

  }
}
