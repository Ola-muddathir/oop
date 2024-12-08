import java.util.ArrayList;
import java.util.List;


class Dish {
    private String name;
    private String description;
    private double price;
    private String category;
    private boolean available;

    // Constructor
    public Dish(String name, String description, double price, String category, boolean available) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.available = available;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
    public boolean getDetails() {
        // You can return true to indicate that the dish is available or something like that
        if (available) {
            System.out.println("Dish: " + name);
            System.out.println("Description: " + description);
            System.out.println("Price: $" + price);
            System.out.println("Category: " + category);
            return true; // Return true to indicate details are being printed
        }
        return false; // If not available, return false
    }
    public boolean isAvailable() {
        return available;
    }
}