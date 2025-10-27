// ECommerceApp.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ECommerceApp {

    public static void main(String[] args) {
        // --- Setup Store Products ---
        List<Product> availableProducts = new ArrayList<>();
        availableProducts.add(new Product("Laptop", 100000));
        availableProducts.add(new Product("Mouse", 1500));
        availableProducts.add(new Product("Keyboard", 1800));
        availableProducts.add(new Product("Monitor", 17500));
        availableProducts.add(new Product("Webcam", 9999));

        // --- Initialize Core Components ---
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        // --- Main Application Loop ---
        while (true) {
            System.out.println("\n===== WELCOME TO THE G-STORE =====");
            System.out.println("1. View all products");
            System.out.println("2. Add a product to your cart");
            System.out.println("3. View your cart");
            System.out.println("4. Checkout (Buy Now) 💳"); // New option
            System.out.println("5. Exit"); // Exit is now 5
            System.out.print("Please select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // --- View Products ---
                    System.out.println("\n--- Available Products ---");
                    for (int i = 0; i < availableProducts.size(); i++) {
                        System.out.println((i + 1) + ". " + availableProducts.get(i));
                    }
                    break;

                case 2:
                    // --- Add to Cart ---
                    System.out.println("\nEnter the number of the product to add to your cart:");
                    for (int i = 0; i < availableProducts.size(); i++) {
                        System.out.println((i + 1) + ". " + availableProducts.get(i).getName());
                    }
                    System.out.print("Your choice: ");
                    int productChoice = scanner.nextInt();
                    if (productChoice > 0 && productChoice <= availableProducts.size()) {
                        Product selectedProduct = availableProducts.get(productChoice - 1);
                        cart.addProduct(selectedProduct);
                        System.out.println("✅ '" + selectedProduct.getName() + "' has been added to your cart.");
                    } else {
                        System.out.println("❌ Invalid product number. Please try again.");
                    }
                    break;

                case 3:
                    // --- View Cart ---
                    System.out.println("\n--- Your Shopping Cart ---");
                    List<Product> cartItems = cart.getItems();
                    if (cartItems.isEmpty()) {
                        System.out.println("Your cart is empty.");
                    } else {
                        for (Product item : cartItems) {
                            System.out.println("- " + item);
                        }
                        System.out.println("------------------------------");
                        System.out.printf("Total: Rs.%.2f%n", cart.calculateTotal());
                    }
                    break;

                // --- NEW CASE 4: CHECKOUT ---
                case 4:
                    System.out.println("\n--- Checkout ---");
                    double total = cart.calculateTotal();
                    if (cart.getItems().isEmpty()) {
                        System.out.println("Your cart is empty. Nothing to buy.");
                    } else {
                        System.out.printf("Your total is Rs.%.2f%n", total);
                        System.out.println("Processing payment...");
                        // (In a real app, this is where you'd connect to a payment gateway)
                        System.out.println("✅ Payment successful! Thank you for your purchase.");
                        cart.clearCart(); // Empty the cart
                    }
                    break;

                // --- UPDATED CASE 5: EXIT ---
                case 5:
                    // --- Exit ---
                    System.out.println("\nThank you for shopping with us! Goodbye. 👋");
                    scanner.close();
                    return; // Exit the main method

                default:
                    System.out.println("❌ Invalid option. Please enter a number between 1 and 5.");
            }
        }
    }
}