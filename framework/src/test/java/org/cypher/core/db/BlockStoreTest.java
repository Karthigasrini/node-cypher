package org.cypher.core.db;

import java.io.File;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.cypher.common.application.CypherApplicationContext;
import org.cypher.common.utils.FileUtil;
import org.cypher.core.Constant;
import org.cypher.core.config.DefaultConfig;
import org.cypher.core.config.args.Args;

@Slf4j
public class BlockStoreTest {

  private static final String dbPath = "output-blockStore-test";
  private static CypherApplicationContext context;

  static {
    Args.setParam(new String[]{"--output-directory", dbPath},
        Constant.TEST_CONF);
    context = new CypherApplicationContext(DefaultConfig.class);
  }

  BlockStore blockStore;

  @Before
  public void init() {
    blockStore = context.getBean(BlockStore.class);
  }

  @After
  public void destroy() {
    Args.clearParam();
    context.destroy();
    FileUtil.deleteDir(new File(dbPath));
  }

  @Test
  public void testCreateBlockStore() {
  }
}
