package models;

import java.util.List;

public class Product {
  public String productName;
  public int pricePerKg;
  public List<Variants> variantsList;

    public Product(String productName, int pricePerKg) {
        this.productName = productName;
        this.pricePerKg = pricePerKg;
    }

    public Product(String productName) {
        this.productName = productName;
    }
}
