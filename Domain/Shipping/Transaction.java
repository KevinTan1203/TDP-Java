package Domain.Shipping;

public class Transaction {
  private Address address;
  private double amount;
  private long senderId;
  private long destinationId;

  public Transaction(double amount, long senderId, long destinationId) {
    this.address = new address("123 Main St", "Springfield", "IL");
    this.amount = amount;
    this.senderId = senderId;
    this.destinationId = destinationId;
  }

  @Override
  public String toString() {
    return address.street;
  }
}
