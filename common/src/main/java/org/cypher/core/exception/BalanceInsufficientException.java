package org.cypher.core.exception;

public class BalanceInsufficientException extends CypherException {

  public BalanceInsufficientException() {
    super();
  }

  public BalanceInsufficientException(String message) {
    super(message);
  }
}
