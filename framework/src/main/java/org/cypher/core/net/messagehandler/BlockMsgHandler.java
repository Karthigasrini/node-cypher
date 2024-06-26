package org.cypher.core.net.messagehandler;

import static org.cypher.core.config.Parameter.ChainConstant.BLOCK_PRODUCED_INTERVAL;
import static org.cypher.core.config.Parameter.ChainConstant.BLOCK_SIZE;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.util.encoders.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.cypher.core.Constant;
import org.cypher.core.capsule.BlockCapsule;
import org.cypher.core.capsule.BlockCapsule.BlockId;
import org.cypher.core.config.args.Args;
import org.cypher.core.exception.P2pException;
import org.cypher.core.exception.P2pException.TypeEnum;
import org.cypher.core.net.CypherNetDelegate;
import org.cypher.core.net.message.BlockMessage;
import org.cypher.core.net.message.CypherMessage;
import org.cypher.core.net.peer.Item;
import org.cypher.core.net.peer.PeerConnection;
import org.cypher.core.net.service.AdvService;
import org.cypher.core.net.service.SyncService;
import org.cypher.core.services.WitnessProductBlockService;
import org.cypher.protos.Protocol.Inventory.InventoryType;

@Slf4j(topic = "net")
@Component
public class BlockMsgHandler implements CypherMsgHandler {

  @Autowired
  private CypherNetDelegate cypherNetDelegate;

  @Autowired
  private AdvService advService;

  @Autowired
  private SyncService syncService;

  @Autowired
  private WitnessProductBlockService witnessProductBlockService;

  private int maxBlockSize = BLOCK_SIZE + Constant.ONE_THOUSAND;

  private boolean fastForward = Args.getInstance().isFastForward();

  @Override
  public void processMessage(PeerConnection peer, CypherMessage msg) throws P2pException {

    BlockMessage blockMessage = (BlockMessage) msg;
    BlockId blockId = blockMessage.getBlockId();

    if (!fastForward && !peer.isFastForwardPeer()) {
      check(peer, blockMessage);
    }

    if (peer.getSyncBlockRequested().containsKey(blockId)) {
      peer.getSyncBlockRequested().remove(blockId);
      syncService.processBlock(peer, blockMessage);
    } else {
      Long time = peer.getAdvInvRequest().remove(new Item(blockId, InventoryType.BLOCK));
      long now = System.currentTimeMillis();
      long interval = blockId.getNum() - cypherNetDelegate.getHeadBlockId().getNum();
      processBlock(peer, blockMessage.getBlockCapsule());
      logger.info(
          "Receive block/interval {}/{} from {} fetch/delay {}/{}ms, "
              + "txs/process {}/{}ms, witness: {}",
          blockId.getNum(),
          interval,
          peer.getInetAddress(),
          time == null ? 0 : now - time,
          now - blockMessage.getBlockCapsule().getTimeStamp(),
          ((BlockMessage) msg).getBlockCapsule().getTransactions().size(),
          System.currentTimeMillis() - now,
          Hex.toHexString(blockMessage.getBlockCapsule().getWitnessAddress().toByteArray()));
    }
  }

  private void check(PeerConnection peer, BlockMessage msg) throws P2pException {
    Item item = new Item(msg.getBlockId(), InventoryType.BLOCK);
    if (!peer.getSyncBlockRequested().containsKey(msg.getBlockId()) && !peer.getAdvInvRequest()
        .containsKey(item)) {
      throw new P2pException(TypeEnum.BAD_MESSAGE, "no request");
    }
    BlockCapsule blockCapsule = msg.getBlockCapsule();
    if (blockCapsule.getInstance().getSerializedSize() > maxBlockSize) {
      throw new P2pException(TypeEnum.BAD_MESSAGE, "block size over limit");
    }
    long gap = blockCapsule.getTimeStamp() - System.currentTimeMillis();
    if (gap >= BLOCK_PRODUCED_INTERVAL) {
      throw new P2pException(TypeEnum.BAD_MESSAGE, "block time error");
    }
  }

  private void processBlock(PeerConnection peer, BlockCapsule block) throws P2pException {
    BlockId blockId = block.getBlockId();
    if (!cypherNetDelegate.containBlock(block.getParentBlockId())) {
      logger.warn("Get unlink block {} from {}, head is {}.", blockId.getString(),
          peer.getInetAddress(), cypherNetDelegate.getHeadBlockId().getString());
      syncService.startSync(peer);
      return;
    }

    Item item = new Item(blockId, InventoryType.BLOCK);
    if (fastForward || peer.isFastForwardPeer()) {
      peer.getAdvInvReceive().put(item, System.currentTimeMillis());
      advService.addInvToCache(item);
    }

    long headNum = cypherNetDelegate.getHeadBlockId().getNum();
    if (block.getNum() < headNum) {
      logger.warn("Receive a low block {}, head {}", blockId.getString(), headNum);
      return;
    }

    boolean flag = cypherNetDelegate.validBlock(block);
    if (flag) {
      if (fastForward) {
        advService.fastForward(new BlockMessage(block));
        cypherNetDelegate.trustNode(peer);
      } else {
        advService.broadcast(new BlockMessage(block));
      }
    }

    try {
      cypherNetDelegate.processBlock(block, false);
      if (!flag) {
        if (fastForward) {
          advService.fastForward(new BlockMessage(block));
        } else {
          advService.broadcast(new BlockMessage(block));
        }
      }

      witnessProductBlockService.validWitnessProductTwoBlock(block);

      cypherNetDelegate.getActivePeer().forEach(p -> {
        if (p.getAdvInvReceive().getIfPresent(blockId) != null) {
          p.setBlockBothHave(blockId);
        }
      });
    } catch (Exception e) {
      logger.warn("Process adv block {} from peer {} failed. reason: {}",
              blockId, peer.getInetAddress(), e.getMessage());
    }
  }

}
