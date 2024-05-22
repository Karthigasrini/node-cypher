package org.cypher.common.overlay.discover.node.statistics;

import lombok.extern.slf4j.Slf4j;
import org.cypher.common.net.udp.message.UdpMessageTypeEnum;
import org.cypher.common.overlay.message.Message;
import org.cypher.core.net.message.FetchInvDataMessage;
import org.cypher.core.net.message.InventoryMessage;
import org.cypher.core.net.message.MessageTypes;
import org.cypher.core.net.message.TransactionsMessage;

@Slf4j
public class MessageStatistics {

  //udp discovery
  public final MessageCount discoverInPing = new MessageCount();
  public final MessageCount discoverOutPing = new MessageCount();
  public final MessageCount discoverInPong = new MessageCount();
  public final MessageCount discoverOutPong = new MessageCount();
  public final MessageCount discoverInFindNode = new MessageCount();
  public final MessageCount discoverOutFindNode = new MessageCount();
  public final MessageCount discoverInNeighbours = new MessageCount();
  public final MessageCount discoverOutNeighbours = new MessageCount();

  //tcp p2p
  public final MessageCount p2pInHello = new MessageCount();
  public final MessageCount p2pOutHello = new MessageCount();
  public final MessageCount p2pInPing = new MessageCount();
  public final MessageCount p2pOutPing = new MessageCount();
  public final MessageCount p2pInPong = new MessageCount();
  public final MessageCount p2pOutPong = new MessageCount();
  public final MessageCount p2pInDisconnect = new MessageCount();
  public final MessageCount p2pOutDisconnect = new MessageCount();

  //tcp cypher
  public final MessageCount cypherInMessage = new MessageCount();
  public final MessageCount cypherOutMessage = new MessageCount();

  public final MessageCount cypherInSyncBlockChain = new MessageCount();
  public final MessageCount cypherOutSyncBlockChain = new MessageCount();
  public final MessageCount cypherInBlockChainInventory = new MessageCount();
  public final MessageCount cypherOutBlockChainInventory = new MessageCount();

  public final MessageCount cypherInCypInventory = new MessageCount();
  public final MessageCount cypherOutCypInventory = new MessageCount();
  public final MessageCount cypherInCypInventoryElement = new MessageCount();
  public final MessageCount cypherOutCypInventoryElement = new MessageCount();

  public final MessageCount cypherInBlockInventory = new MessageCount();
  public final MessageCount cypherOutBlockInventory = new MessageCount();
  public final MessageCount cypherInBlockInventoryElement = new MessageCount();
  public final MessageCount cypherOutBlockInventoryElement = new MessageCount();

  public final MessageCount cypherInCypFetchInvData = new MessageCount();
  public final MessageCount cypherOutCypFetchInvData = new MessageCount();
  public final MessageCount cypherInCypFetchInvDataElement = new MessageCount();
  public final MessageCount cypherOutCypFetchInvDataElement = new MessageCount();

  public final MessageCount cypherInBlockFetchInvData = new MessageCount();
  public final MessageCount cypherOutBlockFetchInvData = new MessageCount();
  public final MessageCount cypherInBlockFetchInvDataElement = new MessageCount();
  public final MessageCount cypherOutBlockFetchInvDataElement = new MessageCount();


  public final MessageCount cypherInCyp = new MessageCount();
  public final MessageCount cypherOutCyp = new MessageCount();
  public final MessageCount cypherInCyps = new MessageCount();
  public final MessageCount cypherOutCyps = new MessageCount();
  public final MessageCount cypherInBlock = new MessageCount();
  public final MessageCount cypherOutBlock = new MessageCount();
  public final MessageCount cypherOutAdvBlock = new MessageCount();

  public void addUdpInMessage(UdpMessageTypeEnum type) {
    addUdpMessage(type, true);
  }

  public void addUdpOutMessage(UdpMessageTypeEnum type) {
    addUdpMessage(type, false);
  }

  public void addTcpInMessage(Message msg) {
    addTcpMessage(msg, true);
  }

  public void addTcpOutMessage(Message msg) {
    addTcpMessage(msg, false);
  }

  private void addUdpMessage(UdpMessageTypeEnum type, boolean flag) {
    switch (type) {
      case DISCOVER_PING:
        if (flag) {
          discoverInPing.add();
        } else {
          discoverOutPing.add();
        }
        break;
      case DISCOVER_PONG:
        if (flag) {
          discoverInPong.add();
        } else {
          discoverOutPong.add();
        }
        break;
      case DISCOVER_FIND_NODE:
        if (flag) {
          discoverInFindNode.add();
        } else {
          discoverOutFindNode.add();
        }
        break;
      case DISCOVER_NEIGHBORS:
        if (flag) {
          discoverInNeighbours.add();
        } else {
          discoverOutNeighbours.add();
        }
        break;
      default:
        break;
    }
  }

  private void addTcpMessage(Message msg, boolean flag) {

    if (flag) {
      cypherInMessage.add();
    } else {
      cypherOutMessage.add();
    }

    switch (msg.getType()) {
      case P2P_HELLO:
        if (flag) {
          p2pInHello.add();
        } else {
          p2pOutHello.add();
        }
        break;
      case P2P_PING:
        if (flag) {
          p2pInPing.add();
        } else {
          p2pOutPing.add();
        }
        break;
      case P2P_PONG:
        if (flag) {
          p2pInPong.add();
        } else {
          p2pOutPong.add();
        }
        break;
      case P2P_DISCONNECT:
        if (flag) {
          p2pInDisconnect.add();
        } else {
          p2pOutDisconnect.add();
        }
        break;
      case SYNC_BLOCK_CHAIN:
        if (flag) {
          cypherInSyncBlockChain.add();
        } else {
          cypherOutSyncBlockChain.add();
        }
        break;
      case BLOCK_CHAIN_INVENTORY:
        if (flag) {
          cypherInBlockChainInventory.add();
        } else {
          cypherOutBlockChainInventory.add();
        }
        break;
      case INVENTORY:
        InventoryMessage inventoryMessage = (InventoryMessage) msg;
        int inventorySize = inventoryMessage.getInventory().getIdsCount();
        messageProcess(inventoryMessage.getInvMessageType(),
                cypherInCypInventory,cypherInCypInventoryElement,cypherInBlockInventory,
                cypherInBlockInventoryElement,cypherOutCypInventory,cypherOutCypInventoryElement,
                cypherOutBlockInventory,cypherOutBlockInventoryElement,
                flag, inventorySize);
        break;
      case FETCH_INV_DATA:
        FetchInvDataMessage fetchInvDataMessage = (FetchInvDataMessage) msg;
        int fetchSize = fetchInvDataMessage.getInventory().getIdsCount();
        messageProcess(fetchInvDataMessage.getInvMessageType(),
                cypherInCypFetchInvData,cypherInCypFetchInvDataElement,cypherInBlockFetchInvData,
                cypherInBlockFetchInvDataElement,cypherOutCypFetchInvData,cypherOutCypFetchInvDataElement,
                cypherOutBlockFetchInvData,cypherOutBlockFetchInvDataElement,
                flag, fetchSize);
        break;
      case CYPS:
        TransactionsMessage transactionsMessage = (TransactionsMessage) msg;
        if (flag) {
          cypherInCyps.add();
          cypherInCyp.add(transactionsMessage.getTransactions().getTransactionsCount());
        } else {
          cypherOutCyps.add();
          cypherOutCyp.add(transactionsMessage.getTransactions().getTransactionsCount());
        }
        break;
      case CYP:
        if (flag) {
          cypherInMessage.add();
        } else {
          cypherOutMessage.add();
        }
        break;
      case BLOCK:
        if (flag) {
          cypherInBlock.add();
        }
        cypherOutBlock.add();
        break;
      default:
        break;
    }
  }
  
  
  private void messageProcess(MessageTypes messageType,
                              MessageCount inCyp,
                              MessageCount inCypEle,
                              MessageCount inBlock,
                              MessageCount inBlockEle,
                              MessageCount outCyp,
                              MessageCount outCypEle,
                              MessageCount outBlock,
                              MessageCount outBlockEle,
                              boolean flag, int size) {
    if (flag) {
      if (messageType == MessageTypes.CYP) {
        inCyp.add();
        inCypEle.add(size);
      } else {
        inBlock.add();
        inBlockEle.add(size);
      }
    } else {
      if (messageType == MessageTypes.CYP) {
        outCyp.add();
        outCypEle.add(size);
      } else {
        outBlock.add();
        outBlockEle.add(size);
      }
    }
  }

}
