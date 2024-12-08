import java.util.ArrayList;

import java.util.ArrayList;
import java.util.HashMap;

class Cart {
    private ArrayList<CartItem> mainDishes;
    private HashMap<String, ArrayList<CartItem>> sideDishes;

    public Cart() {
        this.mainDishes = new ArrayList<>();
        this.sideDishes = new HashMap<>();
    }

    // Add a main dish to the cart
    public void addMainDish(Dish dish, int quantity) {
        CartItem item = new CartItem(dish, quantity);
        mainDishes.add(item);
    }

    // Add a side dish to a specific main dish in the cart
    public void addSideDishToItem(String mainDishName, Dish sideDish, int quantity) {
        boolean found = false;
        // Find the main dish
        for (CartItem item : mainDishes) {
            if (item.getDish().getName().equals(mainDishName)) {
                if (!sideDishes.containsKey(mainDishName)) {
                    sideDishes.put(mainDishName, new ArrayList<>());
                }
                sideDishes.get(mainDishName).add(new CartItem(sideDish, quantity));
                found = true;

            }  break;
        }if (!found) {
            System.out.println("Main dish not found in cart.");
        }
    }

    // View the cart contents (both main dishes and side dishes)
    public void viewCart() {
        if (mainDishes.isEmpty() && sideDishes.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("\n--- Your Cart ---");
            double totalPrice = 0.0;

            // View main dishes
            for (CartItem item : mainDishes) {
                System.out.println(item.getDish().getName() + " - " + item.getQuantity() + " x $" + item.getDish().getPrice());
                totalPrice += item.getQuantity() * item.getDish().getPrice();
                // View side dishes for each main dish
                if (sideDishes.containsKey(item.getDish().getName())) {
                    for (CartItem sideItem : sideDishes.get(item.getDish().getName())) {
                        System.out.println("  - " + sideItem.getDish().getName() + " - " + sideItem.getQuantity() + " x $" + sideItem.getDish().getPrice());
                        totalPrice += sideItem.getQuantity() * sideItem.getDish().getPrice();
                    }
                }
            }

            System.out.println("\nTotal Price: $" + totalPrice);
        }
    }
    public boolean isEmpty(){
        return false;
    }
    public void removeItem(String dishName) {
        // Remove the main dish from the cart
        boolean mainDishRemoved = mainDishes.removeIf(item -> item.getDish().getName().equalsIgnoreCase(dishName));

        // Remove the side dishes associated with the main dish
        if (mainDishRemoved) {
            sideDishes.remove(dishName);
            System.out.println(dishName + " and its associated side dishes have been removed from the cart.");
        } else {
            System.out.println("Item not found in the cart.");
        }
    }

}