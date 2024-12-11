import java.util.*;

public class Cart {
    private List<CartItem> mainDishes = new ArrayList<>();
    private Map<String, List<CartItem>> sideDishes = new HashMap<>();
    public  double totalPrice;

    // Add main dish
    public void addMainDish(Dish dish, int quantity) {
        mainDishes.add(new CartItem(dish, quantity));

    }

    // Add side dish to a specific main dish
    public void addSideDishToCart(String mainDishName, Dish sideDish, int quantity) {
        for (CartItem mainDish : mainDishes) {
            if (mainDish.getDish().getName().equalsIgnoreCase(mainDishName)) {
                sideDishes
                        .computeIfAbsent(mainDishName, k -> new ArrayList<>())
                        .add(new CartItem(sideDish, quantity));

                return;
            }
        }
        System.out.println("Main dish " + mainDishName + " not found in the cart.");
    }

    // View cart
    public void viewCart() {
        if (mainDishes.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("\n=== Your Cart ===");
       // double totalPrice = 0.0;

        for (CartItem mainDish : mainDishes) {
            System.out.println(mainDish.getDish().getName() + " - " + mainDish.getQuantity() + " x $" + mainDish.getDish().getPrice());
            totalPrice += mainDish.getQuantity() * mainDish.getDish().getPrice();

            // Display side dishes
            List<CartItem> associatedSideDishes = sideDishes.get(mainDish.getDish().getName());
            if (associatedSideDishes != null) {
                for (CartItem sideDish : associatedSideDishes) {
                    System.out.println("  - " + sideDish.getDish().getName() + " - " + sideDish.getQuantity() + " x $" + sideDish.getDish().getPrice());
                    totalPrice += sideDish.getQuantity() * sideDish.getDish().getPrice();
                }
            }
        }

        System.out.println("\nTotal Price: $" + totalPrice);
    }

    // Remove item from cart
    public void removeItem(String dishName, int quantity) {
        Iterator<CartItem> iterator = mainDishes.iterator();
        while (iterator.hasNext()) {
            CartItem item = iterator.next();
            if (item.getDish().getName().equalsIgnoreCase(dishName)) {
                if (item.getQuantity() > quantity) {
                    item.setQuantity(item.getQuantity() - quantity);
                    System.out.println(quantity + " " + dishName + " removed from cart.");
                } else {
                    iterator.remove();
                    System.out.println(dishName + " removed from cart.");
                }
                return;
            }


            if (sideDishes.containsKey(dishName)) {
                List<CartItem> sideDishItems = sideDishes.get(dishName);
                for (Iterator<CartItem> sideIterator = sideDishItems.iterator(); sideIterator.hasNext(); ) {
                    CartItem sideItem = sideIterator.next();
                    if (sideItem.getQuantity() > quantity) {
                        sideItem.setQuantity(sideItem.getQuantity() - quantity);
                        System.out.println(quantity + " " + dishName + " (side dish) removed from cart.");
                    } else {
                        sideIterator.remove();
                        System.out.println(dishName + " (side dish) removed from cart.");
                    }
                    return;
                }
            }
        }
        System.out.println(dishName + " not found in cart.");
    } public double gettotalPrice() {
        return totalPrice;
    }
}