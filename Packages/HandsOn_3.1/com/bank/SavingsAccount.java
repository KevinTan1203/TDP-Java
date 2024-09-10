// File: SavingsAccount.java
package com.bank;

import com.bank.math.InterestCalculation;
import com.bank.exceptions.WithdrawalExceedsBalanceException;
import com.bank.math.InterestCalculation;

public class SavingsAccount {
  protected String name;
  protected double balance;
  protected double interestRate;

  // Constructor
  public SavingsAccount(String name, double balance, double interestRate) {
    this.name = name;
    this.balance = balance;
    this.interestRate = interestRate;
  }

  // Getter for balance
  public double getBalance() {
    return balance;
  }

  // Method to deposit money into the account
  public void deposit(double amount) {
    if (amount > 0) {
      balance += amount;
    }
  }

  // Method to withdraw money from the account
  public void withdraw(double amount) throws WithdrawalExceedsBalanceException {
    if (amount <= 0) {
      throw new IllegalArgumentException("Withdrawal amount must be positive.");
    }

    if (amount > balance) {
      throw new WithdrawalExceedsBalanceException("Withdrawal exceeds balance");
    }

    balance -= amount;
    System.out.println("Withdrawal successful. New balance: " + balance);
  }

  // Method to apply compound interest for the given term (in months)
  public void applyCompoundInterest(int term) {
    InterestCalculation calculator = new InterestCalculation();
    double interest = calculator.calculateInterest(balance, interestRate, term);
    balance += interest; // Add the calculated interest to the balance
  }
}
