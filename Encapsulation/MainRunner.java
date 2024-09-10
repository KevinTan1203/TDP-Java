public class MainRunner {
  public static void main(String[] args) {
    BankAccount account = new BankAccount("123456", "John Doe", 1000.0);

    // Deposit money
    account.deposit(500.0);

    // Attempt to withdraw more than balance
    account.withdraw(2000.0);

    // Withdraw a valid amount
    account.withdraw(300.0);

    // Printing account details
    System.out.println("Account Number: " + account.getAccountNumber());
    System.out.println("Account Holder: " + account.getAccountHolderName());
    System.out.println("Balance: $" + account.getBalance());
    System.out.println("Transactions:");

    for (Transaction t : account.getTransactions()) {
      System.out
          .println(" " + t.getTransactionId() + ": $" + t.getAmount() + " (" +
              t.getType() + ") on " + t.getDate());
    }
  }
}
