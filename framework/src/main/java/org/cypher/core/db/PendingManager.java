package org.cypher.core.db;

import java.util.Iterator;
import lombok.extern.slf4j.Slf4j;
import org.cypher.core.capsule.TransactionCapsule;
import org.cypher.core.config.args.Args;

@Slf4j(topic = "DB")
public class PendingManager implements AutoCloseable {

  private Manager dbManager;
  private long timeout = Args.getInstance().getPendingTransactionTimeout();

  public PendingManager(Manager db) {
    this.dbManager = db;
    db.getSession().reset();
    db.getShieldedTransInPendingCounts().set(0);
  }

  @Override
  public void close() {

    long now = System.currentTimeMillis();
    Iterator<TransactionCapsule> iterator = dbManager.getRePushTransactions().iterator();
    while (iterator.hasNext()) {
      if (now - iterator.next().getTime() > timeout) {
        iterator.remove();
      }
    }

    for (TransactionCapsule tx : dbManager.getPendingTransactions()) {
      txIteration(tx);
    }

    dbManager.getPendingTransactions().clear();
    for (TransactionCapsule tx : dbManager.getPoppedTransactions()) {
      tx.setTime(System.currentTimeMillis());
      txIteration(tx);
    }
    dbManager.getPoppedTransactions().clear();
    if (Args.getInstance().isOpenPrintLog()) {
      logger.warn("pending tx size:{}", dbManager.getRePushTransactions().size());
    }
  }

  private void txIteration(TransactionCapsule tx) {
    try {
      if (System.currentTimeMillis() - tx.getTime() < timeout) {
        dbManager.getRePushTransactions().put(tx);
      } else if (Args.getInstance().isOpenPrintLog()) {
        logger.warn("[timeout] remove tx from pending, txId:{}", tx.getTransactionId());
      }
    } catch (InterruptedException e) {
      logger.error(e.getMessage());
      Thread.currentThread().interrupt();
    }
  }
}
