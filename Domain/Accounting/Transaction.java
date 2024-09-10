public class Transaction {
  private double amount;
  private long senderId;
  private long destinationId;

  public Transaction(double amount, long senderId, long destinationId) {
    this.amount = amount;
    this.senderId = senderId;
    this.destinationId = destinationId;
  }
}