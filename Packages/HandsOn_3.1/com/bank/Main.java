// File: Main.java
package com.bank;

public class Main {
  public static void main(String[] args) {
    // Create a savings account with an
    vingsAccount account = new SavingsAccount(1000.0, 5.0);

    // Display the initial balance
    System.out.println("Initial Balance: $" + account.getBalance());

    // Apply compound interest for a term of 12 months
    account.applyCompoundInterest(12);

    // Display the balance after applying compound interest
    System.out.println("Balance after applying compound interest: $" + account.getBalance());
  }
}
