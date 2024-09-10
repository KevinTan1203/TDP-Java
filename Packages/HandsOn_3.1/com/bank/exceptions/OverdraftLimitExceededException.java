package com.bank.exceptions;

public class OverdraftLimitExceededException extends Exception {
  public OverdraftLimitExceededException(String message) {
    super(message);
  }
}
