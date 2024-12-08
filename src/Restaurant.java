
import java.util.ArrayList;

public class Restaurant {
    private String name;
    private String address;
    private String contactNumber;    // New: Contact number for the restaurant
    private String cuisineType;      // New: Type of cuisine (e.g., Italian, Indian, etc.)
    private double rating;           // Average rating of the restaurant
    private ArrayList<String> reviews; // List of reviews
    private ArrayList<String> popularDishes; // New: Popular dishes offered by the restaurant
    private boolean isOpen;          // New: Indicates whether the restaurant is open or closed
    private double earnings;         // New: Total earnings of the restaurant

    // Constructor
    public Restaurant(String name, String address, String contactNumber, String cuisineType, double rating) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.cuisineType = cuisineType;
        this.rating = rating;
        this.reviews = new ArrayList<>();
        this.popularDishes = new ArrayList<>();
        this.isOpen = true;
        this.earnings = 0.0;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public double getEarnings() {
        return earnings;
    }

    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }

    // Add a review
    public void addReview(String review) {
        reviews.add(review);
    }

    // Add a popular dish
    public void addPopularDish(String dish) {
        popularDishes.add(dish);
    }

    // Remove a popular dish
    public void removePopularDish(String dish) {
        popularDishes.remove(dish);
    }

    // View restaurant details
    public void displayDetails() {
        System.out.println("Restaurant Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Cuisine Type: " + cuisineType);
        System.out.println("Rating: " + rating);
        System.out.println("Status: " + (isOpen ? "Open" : "Closed"));
        System.out.println("Earnings: $" + earnings);
        System.out.println("Popular Dishes:");
        for (String dish : popularDishes) {
            System.out.println("- " + dish);
        }
        System.out.println("Reviews:");
        for (String review : reviews) {
            System.out.println("- " + review);
        }
    }

    // Update the restaurant's status (open/closed)
    public void updateStatus(boolean open) {
        this.isOpen = open;
        System.out.println("The restaurant is now " + (isOpen ? "Open" : "Closed"));
    }

    // Update earnings
    public void updateEarnings(double amount) {
        this.earnings += amount;
        System.out.println("Earnings updated. Total earnings: $" + earnings);
    }

    // Calculate the average rating
    public void updateRating(double newRating) {
        this.rating = (this.rating + newRating) / 2;
        System.out.println("Updated rating: " + rating);
    }

    // Check if a dish is popular
    public boolean isPopularDish(String dishName) {
        return popularDishes.contains(dishName);
    }
}

