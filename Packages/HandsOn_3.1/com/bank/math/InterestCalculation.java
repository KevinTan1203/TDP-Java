package com.bank.math;

public class InterestCalculation {

  // Method to calculate compound interest
  public double calculateInterest(double principal, double interestRate, int term) {
    return principal * Math.pow(1.0 + interestRate / 100.0, term) - principal;
  }
}