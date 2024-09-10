package com.bank.exceptions;

public class WithdrawalExceedsBalanceException extends Exception {
  public WithdrawalExceedsBalanceException(String message) {
    super(message);
  }
}
