package org.cypher.common.logsfilter.capsule;

import static org.cypher.core.services.jsonrpc.CypherJsonRpcImpl.handleLogsFilter;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.cypher.common.bloom.Bloom;
import org.cypher.protos.Protocol.TransactionInfo;

@Slf4j(topic = "API")
@ToString
public class LogsFilterCapsule extends FilterTriggerCapsule {

  @Getter
  @Setter
  private long blockNumber;
  @Getter
  @Setter
  private String blockHash;
  @Getter
  @Setter
  private Bloom bloom; // if solidified is true or remove is true, bloom will be null
  @Getter
  @Setter
  private List<TransactionInfo> txInfoList;
  @Getter
  @Setter
  private boolean solidified;
  @Getter
  @Setter
  private boolean removed;

  public LogsFilterCapsule(long blockNumber, String blockHash, Bloom bloom,
      List<TransactionInfo> txInfoList, boolean solidified, boolean removed) {
    this.blockNumber = blockNumber;
    this.blockHash = blockHash;
    this.bloom = bloom;
    this.txInfoList = txInfoList;
    this.solidified = solidified;
    this.removed = removed;
  }

  @Override
  public void processFilterTrigger() {
    handleLogsFilter(this);
  }
}