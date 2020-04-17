package cz.czechitas.webapp;

public class Item {
    String name;
    int price;
    int quantity;

    public Item(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String newValue) {
        name = newValue;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int newValue) {
        price = newValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int newValue) {
        quantity = newValue;
    }
}
