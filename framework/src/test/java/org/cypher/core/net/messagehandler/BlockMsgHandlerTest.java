package org.cypher.core.net.messagehandler;

import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.testng.collections.Lists;
import org.cypher.common.application.CypherApplicationContext;
import org.cypher.common.utils.Sha256Hash;
import org.cypher.core.Constant;
import org.cypher.core.capsule.BlockCapsule;
import org.cypher.core.config.DefaultConfig;
import org.cypher.core.config.Parameter;
import org.cypher.core.config.args.Args;
import org.cypher.core.exception.P2pException;
import org.cypher.core.net.message.BlockMessage;
import org.cypher.core.net.peer.Item;
import org.cypher.core.net.peer.PeerConnection;
import org.cypher.protos.Protocol.Inventory.InventoryType;
import org.cypher.protos.Protocol.Transaction;

public class BlockMsgHandlerTest {

  protected CypherApplicationContext context;
  private BlockMsgHandler handler;
  private PeerConnection peer;

  /**
   * init context.
   */
  @Before
  public void init() {
    Args.setParam(new String[]{"--output-directory", "output-directory", "--debug"},
        Constant.TEST_CONF);
    context = new CypherApplicationContext(DefaultConfig.class);
    handler = context.getBean(BlockMsgHandler.class);
    peer = context.getBean(PeerConnection.class);
  }

  @Test
  public void testProcessMessage() {
    BlockCapsule blockCapsule;
    BlockMessage msg;
    try {
      blockCapsule = new BlockCapsule(1, Sha256Hash.ZERO_HASH,
          System.currentTimeMillis(), Sha256Hash.ZERO_HASH.getByteString());
      msg = new BlockMessage(blockCapsule);
      handler.processMessage(peer, msg);
    } catch (P2pException e) {
      Assert.assertTrue(e.getMessage().equals("no request"));
    }

    try {
      List<Transaction> transactionList = ImmutableList.of(
          Transaction.newBuilder()
              .setRawData(Transaction.raw.newBuilder()
                  .setData(
                      ByteString.copyFrom(
                          new byte[Parameter.ChainConstant.BLOCK_SIZE + Constant.ONE_THOUSAND])))
              .build());
      blockCapsule = new BlockCapsule(1, Sha256Hash.ZERO_HASH.getByteString(),
          System.currentTimeMillis() + 10000, transactionList);
      msg = new BlockMessage(blockCapsule);
      System.out.println("len = " + blockCapsule.getInstance().getSerializedSize());
      peer.getAdvInvRequest()
          .put(new Item(msg.getBlockId(), InventoryType.BLOCK), System.currentTimeMillis());
      handler.processMessage(peer, msg);
    } catch (P2pException e) {
      //System.out.println(e);
      Assert.assertTrue(e.getMessage().equals("block size over limit"));
    }

    try {
      blockCapsule = new BlockCapsule(1, Sha256Hash.ZERO_HASH,
          System.currentTimeMillis() + 10000, Sha256Hash.ZERO_HASH.getByteString());
      msg = new BlockMessage(blockCapsule);
      peer.getAdvInvRequest()
          .put(new Item(msg.getBlockId(), InventoryType.BLOCK), System.currentTimeMillis());
      handler.processMessage(peer, msg);
    } catch (P2pException e) {
      //System.out.println(e);
      Assert.assertTrue(e.getMessage().equals("block time error"));
    }

    try {
      blockCapsule = new BlockCapsule(1, Sha256Hash.ZERO_HASH,
          System.currentTimeMillis() + 1000, Sha256Hash.ZERO_HASH.getByteString());
      msg = new BlockMessage(blockCapsule);
      peer.getSyncBlockRequested()
          .put(msg.getBlockId(), System.currentTimeMillis());
      handler.processMessage(peer, msg);
    } catch (P2pException e) {
      //System.out.println(e);
    }

    try {
      blockCapsule = new BlockCapsule(1, Sha256Hash.ZERO_HASH,
          System.currentTimeMillis() + 1000, Sha256Hash.ZERO_HASH.getByteString());
      msg = new BlockMessage(blockCapsule);
      peer.getAdvInvRequest()
          .put(new Item(msg.getBlockId(), InventoryType.BLOCK), System.currentTimeMillis());
      handler.processMessage(peer, msg);
    } catch (NullPointerException | P2pException e) {
      System.out.println(e);
    }
  }

  @After
  public void destroy() {
    Args.clearParam();
    context.destroy();
  }
}
