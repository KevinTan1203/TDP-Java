package com.example;

import java.util.*;

public class BasicClass {
  public static void main(String[] args) {
    Customer customer0 = new Customer();
    System.out.println("First Name: " + customer0.firstName);
    System.out.println("Last Name: " + customer0.lastName);

    Customer customer1 = new Customer();
    customer1.firstName = "John";
    customer1.lastName = "Doe";

    System.out.println("First Name: " + customer1.firstName);
    System.out.println("Last Name: " + customer1.lastName);

    Customer customer2 = new Customer();
    customer2.firstName = "Jane";
    customer2.lastName = "Mary";

    System.out.println("First Name: " + customer2.firstName);
    System.out.println("Last Name: " + customer2.lastName);

    // Testing out the default and overloaded constructors
    Bill bill0 = new Bill();
    System.out.println("Reference: " + bill0.getReference());
    System.out.println("Total: " + bill0.getTotal());

    Bill bill1 = new Bill("INV-001", 100.0);
    System.out.println("Reference: " + bill1.getReference());
    System.out.println("Total: " + bill1.getTotal());

    // Inheritance
    ArrayList<SavingsAccount> accounts = new ArrayList<SavingsAccount>();
    accounts.add(new SavingsAccount());

    // To add banking and savings account into the same array list
    ArrayList<BankAccount> accounts0 = new ArrayList<BankAccount>();
    accounts0.add(new SavingsAccount());
    accounts0.add(new CheckingAccount());

    // Polymorphism
    /*
     * A more generic reference can store a more specific object
     * class hierachy
     * 
     * Since variable type is product, we cannot use it to refer to any of the
     * methods that a child class will have
     */
    Product product0 = new PhysicalProduct();
    Product product1 = new DigitalProduct();

    // However, we can use typecasting to access the methods of the child class
    // But this a bad practise
    ((PhysicalProduct) product0).setStock(10);
    ((DigitalProduct) product1).getFileName();

    ArrayList<Product> catalog = new ArrayList<>();
    catalog.add(new PhysicalProduct("ACME Anvil", "A1", 100, 10, 5.0));
    catalog.add(new DigitalProduct("Lord of the Rings", "Ek1", 50, "mp3", "lotr.mp3", 1024));

    for (Product product : catalog) {
      System.out.println(product.getName());
      System.out.println(product.calculateTotalPrice());
    }
  }
}

// Once a class has been defined, we can use it as a datattype
// Set default values for the fields
class Customer {
  // Propoerties or fields
  public String firstName;
  public String lastName;

  // Constructor to assign default values to the class fields
  public Customer() {
    this.firstName = "N/A";
    this.lastName = "N/A";
  }
}

// Default and Overloaded Constructors
class Bill {
  private String reference;
  private double total;

  // Default Constructor
  public Bill() {
    this.reference = "N/A";
    this.total = 0.0;
  }

  // Overloaded Cnnstructor
  public Bill(String reference, double total) {
    this.reference = reference;
    this.total = total;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }
}

// Inheritance
// <child class> extends <parent class>
class BankAccount {
  private String firstName;
  private String lastName;
  private double balance;

  public BankAccount() {
    this.firstName = "N/A";
    this.lastName = "N/A";
    this.balance = 0.0;
  }

  public BankAccount(String firstName, String lastName, double balance) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.balance = balance;
  }
}

class SavingsAccount extends BankAccount {
  private double interestRate;

  public SavingsAccount() {
    super();
    this.interestRate = 0.0;
  }

  public SavingsAccount(String firstName, String lastName, double balance, double interestRate) {
    super(firstName, lastName, balance);
    this.interestRate = interestRate;
  }
}

class CheckingAccount extends BankAccount {
  private double overDraftList;

  public CheckingAccount() {
    super();
    this.overDraftList = 0.0;
  }

  public CheckingAccount(String firstName, String lastName, double balance, double overDraftList) {
    super(firstName, lastName, balance);
    this.overDraftList = overDraftList;
  }

}

class DebitAccount extends SavingsAccount {
  private String cardNumber;
  private int cvc;

  public DebitAccount(String firstName, String lastName, double balance, double interestRate, String cardNumber,
      int cvc) {
    super(firstName, lastName, balance, interestRate);
    this.cardNumber = cardNumber;
    this.cvc = cvc;
  }
}

// Encapsulation
// Business rules specific to the class are only implemeented within the class
class Animal {
  // If a memeber of a class is marked as private, it can only be accessed within
  // the class. No other classes can access it
  private String name;
  private String species;
  private int monthsInSystem;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public int getMonthsInSystem() {
    return monthsInSystem;
  }

  public void setMonthsInSystem(int monthsInSystem) {
    if (monthsInSystem > 0) {
      this.monthsInSystem = monthsInSystem;
    }
  }
}

// Polymorphism (of many forms)
/*
 * A more specific reference can store a more specific object
 */

class Product {
  protected String name;
  protected String sku;
  protected double price;

  public Product() {
    this.name = "N/A";
    this.sku = "N/A";
    this.price = 0.0;
  }

  public Product(String name, String sku, double price) {
    this.name = name;
    this.sku = sku;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double calculateTotalPrice() {
    return price;
  }
}

class PhysicalProduct extends Product {
  private int stock;
  private double weight;

  public PhysicalProduct() {
    super();
    this.stock = 0; // not ncessary to instantiate here as it defaults to 0 anyways
    this.weight = 0.0;
  }

  public PhysicalProduct(String name, String sku, double price, int stock, double weight) {
    super(name, sku, price);
    this.stock = stock;
    this.weight = weight;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  @Override
  public double calculateTotalPrice() {
    double weightPrice = 0;
    if (weight > 0) {
      weightPrice = weight * 0.5;
    } else if (weight > 5) {
      weightPrice = weight * 1.0;
    } else {
      weightPrice = weight * 1.5;
    }
    return weightPrice;
  }
}

class DigitalProduct extends Product {
  private String fileFormat;
  private String fileName;
  private int fileSize;

  public DigitalProduct() {
    super();
    this.fileFormat = "N/A";
    this.fileName = "N/A";
    this.fileSize = 0;
  }

  public DigitalProduct(String name, String sku, double price, String fileFormat, String fileName, int fileSize) {
    super(name, sku, price);
    this.fileFormat = fileFormat;
    this.fileName = fileName;
    this.fileSize = fileSize;
  }

  public String getFileFormat() {
    return fileFormat;
  }

  public void setFileFormat(String fileFormat) {
    this.fileFormat = fileFormat;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public int getFileSize() {
    return fileSize;
  }

  public void setFileSize(int fileSize) {
    this.fileSize = fileSize;
  }

  @Override
  public double calculateTotalPrice() {
    return price + (fileSize / 1024) * 0.01;
  }
}

class SubscriptionProduct extends Product {
  @Override
  public double calculateTotalPrice() {
    return price * 12;
  }
}

// Abstract Class
/*
 * Abstract classes must have at least one abstract method
 */
abstract class Shape {
  protected String name;

  public Shape() {
    this.name = "N/A";
  }

  public Shape(String name) {
    this.name = name;
  }

  public abstract double calculateArea();
}

// All classes that implements interface must have their own version of the
// implemented method
class Subscription implements Purchaseable {
  private String name;
  private double fees;
  private int recurringPeriod;
  private ArrayList<String> permissions = new ArrayList<String>();

  public Subscription() {
  }

  public Subscription(String name, double fees, int recurringPeriod, ArrayList<String> permissions) {
    this.name = name;
    this.fees = fees;
    this.recurringPeriod = recurringPeriod;
    this.permissions = permissions;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getFees() {
    return fees;
  }

  public void setFees(double fees) {
    this.fees = fees;
  }

  public int getRecurringPeriod() {
    return recurringPeriod;
  }

  public void setRecurringPeriod(int recurringPeriod) {
    this.recurringPeriod = recurringPeriod;
  }

  public ArrayList<String> getPermissions() {
    return permissions;
  }

  public void setPermissions(ArrayList<String> permissions) {
    this.permissions = permissions;
  }

  public String getPurchaseSummary() {
    return "Subscription: " + name + " at " + fees + " per " + recurringPeriod + " days";
  }
}

// Interface
// Interfaces cannot have data stored inside it
interface Purchaseable {
  public String getPurchaseSummary();
}