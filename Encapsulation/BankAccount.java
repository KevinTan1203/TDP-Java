import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Date;

class BankAccount {
  private String accountNumber;
  private String accountHolderName;
  private double balance;
  private List<Transaction> transactions;

  // Constructor
  public BankAccount(String accountNumber, String accountHolderName, double balance) {
    this.accountNumber = accountNumber;
    this.accountHolderName = accountHolderName;
    this.balance = balance;
    this.transactions = new ArrayList<>();
  }

  // Getter methods
  public String getAccountNumber() {
    return accountNumber;
  }

  public String getAccountHolderName() {
    return accountHolderName;
  }

  public double getBalance() {
    return balance;
  }

  public List<Transaction> getTransactions() {
    return new ArrayList<>(transactions); // Return a copy to avoid external modification
  }

  // Deposit method
  public boolean deposit(double amount) {
    if (amount > 0) {
      balance += amount;
      addTransaction(amount, "DEPOSIT");
      return true;
    } else {
      System.out.println("Invalid deposit amount");
      return false;
    }
  }

  // Withdraw method
  public boolean withdraw(double amount) {
    if (amount > 0 && balance >= amount) {
      balance -= amount;
      addTransaction(-amount, "WITHDRAWAL");
      return true;
    } else {
      System.out.println("Withdrawal failed: Insufficient funds or invalid amount");
      return false;
    }
  }

  // Private method to add a transaction
  private void addTransaction(double amount, String type) {
    if (isValidTransactionType(type)) {
      String transactionId = java.util.UUID.randomUUID().toString();
      Transaction transaction = new Transaction(transactionId, amount, type);
      transactions.add(transaction);
    } else {
      System.out.println("Invalid transaction type: " + type);
    }
  }

  // Validation for transaction type
  private boolean isValidTransactionType(String type) {
    return "DEPOSIT".equals(type) || "WITHDRAWAL".equals(type);
  }
}
