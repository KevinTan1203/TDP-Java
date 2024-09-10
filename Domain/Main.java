import Domain.Shipping.Transaction;
import Domain.Accounting.Transaction;

public class Main {
  Transaction shippingTransaction = new Transaction(100.0, 1, 2);

  // Using the fully qualified name
  Domain.Accounting.Transaction accountingTransaction = new Domain.Shipping.Transaction(100.0, 1, 2);
}
