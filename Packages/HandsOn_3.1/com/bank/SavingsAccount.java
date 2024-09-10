// File: SavingsAccount.java
package com.bank;

import com.bank.math.InterestCalculation;

public class SavingsAccount {

  private double balance;
  private double interestRate;

  // Constructor
  public SavingsAccount(double initialBalance, double interestRate) {
    this.balance = initialBalance;
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
  public void withdraw(double amount) {
    if (amount > 0 && amount <= balance) {
      balance -= amount;
    }
  }

  // New method: Apply compound interest for the given term (in months)
  public void applyCompoundInterest(int term) {
    InterestCalculation calculator = new InterestCalculation();
    double interest = calculator.calculateInterest(balance, interestRate, term);
    balance += interest; // Add the calculated interest to the balance
  }
}
