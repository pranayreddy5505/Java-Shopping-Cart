// ShoppingCart.java
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    // A list to hold the products in the cart
    private List<Product> items;

    // Constructor to initialize the list
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    // Method to add a product to the cart
    public void addProduct(Product product) {
        items.add(product);
    }

    // Method to get all items in the cart
    public List<Product> getItems() {
        return items;
    }

    // Method to calculate the total price of all items in the cart
    public double calculateTotal() {
        double total = 0.0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }
    // Add this method inside your ShoppingCart.java class
    public void clearCart() {
        items.clear();
    }
}