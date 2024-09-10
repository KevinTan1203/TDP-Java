package com.bank;

import com.bank.exceptions.OverdraftLimitExceededException;

public class CheckingAccount extends SavingsAccount {
  protected double overdraftLimit;

  // Constructor
  public CheckingAccount(String name, double balance, double interestRate, double overdraftLimit) {
    super(name, balance, interestRate);
    this.overdraftLimit = overdraftLimit;
  }

  @Override
  public void withdraw(double amount) throws WithdrawalExceedsBalanceException, OverdraftLimitExceededException {
    if (amount <= 0) {
      throw new IllegalArgumentException("Withdrawal amount must be positive.");
    }

    if (amount > balance) {
      if (balance - amount < -overdraftLimit) {
        throw new OverdraftLimitExceededException("Overdraft Limit exceeded");
      }
    }

    balance -= amount;
    System.out.println("Withdrawal successful. New balance: " + balance);
  }
}
