package org.cypher.core.consensus;

import java.util.concurrent.atomic.AtomicBoolean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.cypher.common.overlay.server.SyncPool;
import org.cypher.consensus.base.PbftInterface;
import org.cypher.consensus.pbft.message.PbftBaseMessage;
import org.cypher.core.capsule.BlockCapsule;
import org.cypher.core.db.Manager;
import org.cypher.core.exception.BadItemException;
import org.cypher.core.exception.ItemNotFoundException;

@Component
public class PbftBaseImpl implements PbftInterface {

  @Autowired
  private SyncPool syncPool;

  @Autowired
  private Manager manager;

  @Override
  public boolean isSyncing() {
    if (syncPool == null) {
      return true;
    }
    AtomicBoolean result = new AtomicBoolean(false);
    syncPool.getActivePeers().forEach(peerConnection -> {
      if (peerConnection.isNeedSyncFromPeer()) {
        result.set(true);
        return;
      }
    });
    return result.get();
  }

  @Override
  public void forwardMessage(PbftBaseMessage message) {
    if (syncPool == null) {
      return;
    }
    syncPool.getActivePeers().forEach(peerConnection -> {
      peerConnection.sendMessage(message);
    });
  }

  @Override
  public BlockCapsule getBlock(long blockNum) throws BadItemException, ItemNotFoundException {
    return manager.getChainBaseManager().getBlockByNum(blockNum);
  }
}