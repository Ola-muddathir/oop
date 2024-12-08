public class CartItem {
    private Dish dish;
    private int quantity;
    private Dish price;
    private Dish sideDish;  // Add the side dish

    public CartItem(Dish dish, int quantity) {
        this.dish = dish;
        this.quantity = quantity;
        this.sideDish = null;  // Initially no side dish
    }

    // Optionally, we can set a side dish when creating the CartItem
    public CartItem(Dish dish, int quantity,Dish price, Dish sideDish) {
        this.dish = dish;
        this.quantity = quantity;
        this.price = price;
        this.sideDish = sideDish;
    }

    public double getSubtotal() {
        double subtotal = dish.getPrice() * quantity;
        if (sideDish != null) {
            subtotal += sideDish.getPrice();  // Add price of side dish if exists
        }
        return subtotal;
    }

    // Getters and setters for the side dish
    public void addSideDish(Dish sideDish) {
        this.sideDish = sideDish;
    }

    public Dish getSideDish() {
        return sideDish;
    }


    public int getQuantity() {
        return quantity;
    }

    public Dish getDishPrice() {
        return price;
    }

    public Dish  getDish() {
        return dish;
    }
}

