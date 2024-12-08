
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import java.util.*;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();

        // Create sample main dishes
        ArrayList<Dish> mainDishes = new ArrayList<>();
        mainDishes.add(new Dish("Burger", "Beef with lettuce and tomato", 8.99, "Fast Food", true));
        mainDishes.add(new Dish("Pizza", "Cheese pizza with tomato sauce", 12.99, "Italian", true));
        mainDishes.add(new Dish("Pasta", "Spaghetti with meatballs", 10.49, "Italian", true));

        // Create sample side dishes
        ArrayList<Dish> sideDishes = new ArrayList<>();
        sideDishes.add(new Dish("Fries", "Crispy fried potatoes", 2.99, "Sides", true));
        sideDishes.add(new Dish("Coleslaw", "Fresh cabbage with dressing", 1.99, "Sides", true));
        sideDishes.add(new Dish("Sauce", "BBQ sauce", 0.99, "Sides", true));

        // Main loop
        while (true) {
            // Show menu to the user
            System.out.println("--- Food Ordering System ---");
            System.out.println("1. Search");
            System.out.println("2. View Full Menu");
            System.out.println("3. View Cart");
            System.out.println("4. remove Item from cart");
            System.out.print("Choose an option : ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (option == 1) {
                // Search menu
                System.out.println("1. Search by Name");
                System.out.println("2. Search by Category");
                System.out.print("Choose a search type : ");
                int searchType = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                boolean found = false;

                if (searchType == 1) {
                    // Search by Name
                    System.out.print("Enter search value (name): ");
                    String searchValue = scanner.nextLine().toLowerCase();

                    // Search through main dishes by name
                    for (Dish dish : mainDishes) {
                        if (dish.getName().toLowerCase().contains(searchValue)) {
                            found = true;
                            System.out.println("\nFound: " + dish.getName() + " - $" + dish.getPrice());
                            System.out.print("Do you want to add this dish to the cart? (y/n): ");
                            String addToCart = scanner.nextLine().toLowerCase();
                            if (addToCart.equals("y")) {
                                // Ask for quantity after adding to cart
                                System.out.print("How many would you like to add? ");
                                int quantity = scanner.nextInt();
                                scanner.nextLine();  // Consume newline
                                cart.addMainDish(dish, quantity);
                                System.out.println(quantity + " " + dish.getName() + " added to cart.");


// Ask for side dish if any
                                System.out.print("Would you like to add a side dish? (y/n): ");
                                String addSideDish = scanner.nextLine().toLowerCase();
                                if (addSideDish.equals("y")) {
                                    System.out.println("Available side dishes:");
                                    for (Dish sideDish : sideDishes) {
                                        System.out.println(sideDish.getName() + " - $" + sideDish.getPrice());
                                    }
                                    System.out.print("Enter the name of the side dish to add: ");
                                    String sideDishName = scanner.nextLine().toLowerCase();
                                    for (Dish sideDish : sideDishes) {
                                        if (sideDish.getName().toLowerCase().contains(sideDishName)) {
                                            System.out.print("How many " + sideDish.getName() + " would you like to add? ");
                                            int sideDishQuantity = scanner.nextInt();
                                            scanner.nextLine();  // Consume newline
                                            cart.addSideDishToItem(dish.getName(), sideDish, sideDishQuantity);
                                            System.out.println(sideDishQuantity + " " + sideDish.getName() + " added to cart.");
                                            break;
                                        }
                                    }
                                }
                            }
                            break;
                        }
                    }
                } else if (searchType == 2) {
                    // Search by Category
                    System.out.print("Enter search value (category): ");
                    String searchValue = scanner.nextLine().toLowerCase();

                    // Search through main dishes by category
                    for (Dish dish : mainDishes) {
                        if (dish.getCategory().toLowerCase().contains(searchValue)) {
                            found = true;
                            System.out.println("\nFound: " + dish.getName() + " - $" + dish.getPrice());
                            System.out.print("Do you want to add this dish to the cart? (y/n): ");
                            String addToCart = scanner.nextLine().toLowerCase();
                            if (addToCart.equals("y")) {
                                // Ask for quantity after adding to cart
                                System.out.print("How many would you like to add? ");
                                int quantity = scanner.nextInt();
                                scanner.nextLine();  // Consume newline
                                cart.addMainDish(dish, quantity);
                                System.out.println(quantity + " " + dish.getName() + " added to cart.");

// Ask for side dish if any
                                System.out.print("Would you like to add a side dish? (y/n): ");
                                String addSideDish = scanner.nextLine().toLowerCase();
                                if (addSideDish.equals("y")) {
                                    System.out.println("Available side dishes:");
                                    for (Dish sideDish : sideDishes) {
                                        System.out.println(sideDish.getName() + " - $" + sideDish.getPrice());
                                    }
                                    System.out.print("Enter the name of the side dish to add: ");
                                    String sideDishName = scanner.nextLine().toLowerCase();
                                    for (Dish sideDish : sideDishes) {
                                        if (sideDish.getName().toLowerCase().contains(sideDishName)) {
                                            System.out.print("How many " + sideDish.getName() + " would you like to add? ");
                                            int sideDishQuantity = scanner.nextInt();
                                            scanner.nextLine();  // Consume newline
                                            cart.addSideDishToItem(dish.getName(), sideDish, sideDishQuantity);
                                            System.out.println(sideDishQuantity + " " + sideDish.getName() + " added to cart.");
                                            break;
                                        }
                                    }
                                }
                            }
                            break;
                        }
                    }
                } else {
                    System.out.println("Invalid search type.");
                }

                if (!found) {
                    System.out.println("No dishes found matching your search.");
                }

            } else if (option == 2) {
                // Display full menu
                System.out.println("\n--- Full Menu ---");
                for (Dish dish : mainDishes) {
                    System.out.println(dish.getName() + " - $" + dish.getPrice());
                }
                System.out.print("Enter the dish name to add to your cart: ");
                String dishName = scanner.nextLine().toLowerCase();
                boolean added = false;
                for (Dish dish : mainDishes) {
                    if (dish.getName().toLowerCase().contains(dishName)) {
                        System.out.print("Do you want to add this dish to the cart? (y/n): ");
                        String addToCart = scanner.nextLine().toLowerCase();
                        if (addToCart.equals("y")) {
                            // Ask for quantity after adding to cart
                            System.out.print("How many would you like to add? ");
                            int quantity = scanner.nextInt();
                            scanner.nextLine();  // Consume newline
                            cart.addMainDish(dish, quantity);
                            System.out.println(quantity + " " + dish.getName() + " added to cart.");
                            added = true;


// Ask for side dish if any
                            System.out.print("Would you like to add a side dish? (y/n): ");
                            String addSideDish = scanner.nextLine().toLowerCase();
                            if (addSideDish.equals("y")) {
                                System.out.println("Available side dishes:");
                                for (Dish sideDish : sideDishes) {
                                    System.out.println(sideDish.getName() + " - $" + sideDish.getPrice());
                                }
                                System.out.print("Enter the name of the side dish to add: ");
                                String sideDishName = scanner.nextLine().toLowerCase();
                                for (Dish sideDish : sideDishes) {
                                    if (sideDish.getName().toLowerCase().contains(sideDishName)) {
                                        System.out.print("How many " + sideDish.getName() + " would you like to add? ");
                                        int sideDishQuantity = scanner.nextInt();
                                        scanner.nextLine();  // Consume newline
                                        cart.addSideDishToItem(dishName, sideDish, sideDishQuantity);
                                        System.out.println(sideDishQuantity + " " + sideDish.getName() + " added to the cart.");
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                    }
                }
                if (!added) {
                    System.out.println("Dish not found.");
                }
            } else if (option == 3) {
                // View cart
                cart.viewCart();

            }

            // Ask if they want to continue
            System.out.print("Would you like to continue? (y/n): ");
            String continueOrder = scanner.nextLine().toLowerCase();
            if (!continueOrder.equals("y")) {
                break;
            }
                if (cart.isEmpty()) {
                    System.out.println("Your cart is empty. No items to remove.");
                } else {
                    System.out.println("Items in your cart:");
                    cart.viewCart();

                    System.out.print("Enter the name of the dish you want to remove: ");
                    String dishToRemove = scanner.nextLine().trim();

                    cart.removeItem(dishToRemove);
                    System.out.println("Item removed from your cart.");

                    // Option to continue removing items or return to the main menu
                    System.out.print("Do you want to remove another item? (y/n): ");
                    String removeAgain = scanner.nextLine().trim().toLowerCase();

                    switch (removeAgain) {
                        case "y":
                            break;
                        case "n":
                            continue; // Go back to the main menu
                        default:
                            System.out.println("Invalid input. Returning to main menu.");
                            continue;
                    }
                }
                break;

        }


            System.out.println("Thank you for using the Food Ordering System!");
        }
    }