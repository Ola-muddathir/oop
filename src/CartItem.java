import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.List;


public class CartItem {
    private Dish dish;
    private int quantity;
    private Dish price;
    private Dish sideDish;

    public CartItem(Dish dish, int quantity) {
        this.dish = dish;
        this.quantity = quantity;
        this.sideDish = null;

    }


    public CartItem(Dish dish, int quantity,Dish price, Dish sideDish) {
        this.dish = dish;
        this.quantity = quantity;
        this.price = price;
        this.sideDish = sideDish;
    }

    public double getSubtotal() {
        double subtotal = dish.getPrice() * quantity;
        if (sideDish != null) {
            subtotal += sideDish.getPrice();
        }
        return subtotal;
    }
    public double getPrice() {
        return price.getPrice();
    }
    public void addSideDish(Dish sideDish) {
        this.sideDish = sideDish;
    }

    public Dish getSideDish() {
        return sideDish;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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