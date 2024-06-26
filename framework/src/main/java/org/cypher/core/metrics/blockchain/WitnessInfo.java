package org.cypher.core.metrics.blockchain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WitnessInfo {
  private String address;
  private int version;
}
