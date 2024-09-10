// File: Main.java
package com.bank;

public class Main {
  public static void main(String[] args) {
    SavingsAccount account = new SavingsAccount(500, 100); // initial balance of 500 and overdraft limit of 100

    try {
      // Example 1: Withdrawal exceeds balance
      account.withdraw(600); // This will trigger "Withdrawal exceeds balance" exception
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      // Example 2: Overdraft limit exceeded
      account.withdraw(150); // This will trigger "Overdraft Limit exceeded" exception
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    // Display remaining balance
    System.out.println("Remaining Balance: " + account.getBalance());
  }
}
