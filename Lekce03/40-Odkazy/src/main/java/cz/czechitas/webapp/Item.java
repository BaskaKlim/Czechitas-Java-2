package cz.czechitas.webapp;

public class Item {
    String Item;
    int Price;
    int Quantity;

    public Item(String item, int price, int quantity) {
        Item = item;
        Price = price;
        Quantity = quantity;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String newValue) {
        Item = newValue;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int newValue) {
        Price = newValue;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int newValue) {
        Quantity = newValue;
    }
}
