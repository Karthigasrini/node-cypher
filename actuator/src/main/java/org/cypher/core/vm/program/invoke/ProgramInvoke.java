package org.cypher.core.vm.program.invoke;

import org.cypher.common.runtime.vm.DataWord;
import org.cypher.core.vm.repository.Repository;

public interface ProgramInvoke {

  DataWord getContractAddress();

  DataWord getBalance();

  DataWord getOriginAddress();

  DataWord getCallerAddress();

  DataWord getCallValue();

  DataWord getTokenValue();

  DataWord getTokenId();

  DataWord getDataSize();

  DataWord getDataValue(DataWord indexData);

  byte[] getDataCopy(DataWord offsetData, DataWord lengthData);

  DataWord getPrevHash();

  DataWord getCoinbase();

  DataWord getTimestamp();

  DataWord getNumber();

  DataWord getDifficulty();

  boolean byTestingSuite();

  int getCallDeep();

  Repository getDeposit();

  boolean isStaticCall();

  long getVmShouldEndInUs();

  long getVmStartInUs();

  long getEnergyLimit();

  void setConstantCall();

  boolean isConstantCall();

}
