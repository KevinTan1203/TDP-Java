import java.util.Date;

public class Transaction {
  private final String transactionId;
  private final double amount;
  private final String type;
  private final Date date;

  // Constructor
  public Transaction(String transactionId, double amount, String type) {
    this.transactionId = transactionId;
    this.amount = amount;
    this.type = type;
    this.date = new Date(); // Capture current date at the time of creation
  }

  // Getter methods to access transaction data
  public String getTransactionId() {
    return transactionId;
  }

  public double getAmount() {
    return amount;
  }

  public String getType() {
    return type;
  }

  public Date getDate() {
    return new Date(date.getTime()); // Return a copy to protect immutability
  }
}
