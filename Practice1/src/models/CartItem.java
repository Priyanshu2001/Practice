package models;

public class CartItem {
    public String name;
    public int price;
    public float qty;

    public CartItem(String name, int price, float qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public CartItem(String name, int price) {
        this.name = name;
        this.price = price;
        this.qty=1;
    }
}
