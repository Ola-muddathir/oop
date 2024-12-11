
import java.util.ArrayList;


public class Admin extends User {
    private String AdminName;
    private String AdminPass;
    private ArrayList<Restaurant> restaurants;
    private ArrayList<Order> orders;
    private ArrayList<Dish> dishs;


    public Admin(String AdminName, String AdminPass) {
        super();
        this.AdminName = AdminName;
        this.AdminPass = AdminPass;
        this.restaurants = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.dishs = new ArrayList<>();
    }


    public void setAdminName(String AdminName) {
        this.AdminName = AdminName;
    }

    public void setAdminPass(String AdminPass) {
        this.AdminPass = AdminPass;
    }

    public String getAdminName() {
        return AdminName;
    }

    public String getAdminPass() {
        return AdminPass;
    }


    public void addrestaurant(Restaurant rest) {
        if (rest != null) {
            restaurants.add(rest);
            System.out.println("Restaurant " + rest.getName() + " adedd successfully");
        } else {
            System.out.println("restaurant not added");
        }
    }

    public void removeRestaurant(String restname) {
        boolean remove = false;
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getName().equals(restname)) {
                restaurants.remove(i);
                System.out.println("Restaurant " + restname + " has been successfuly deleted");
                remove = true;
                break;
            }
        }
        if (!remove) {
            System.out.println("Restaurant " + restname + " not found");
        }
    }

    public void viewAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("no order available");

        } else {
            System.out.println("************************  all orders  ************************ ");
            for (Order order : orders) {
                System.out.println(order);
            }
        }

    }


    public void adddish(Dish dish) {
        if (dish != null) {
            dishs.add(dish);
            System.out.println("dishs" + dish.getName() + " added successfully");
        } else {
            System.out.println("dish" + dish.getName() + " not added");
        }
    }

    public void removedish(String dishname) {
        boolean remove = false;
        for (int i = 0; i < dishs.size(); i++) {
            if (dishs.get(i).getName().equals(dishname)) {
                dishs.remove(i);
                System.out.println("Dish " + dishname + " has been successfuly deleted");
                remove = true;
                break;
            }
        }
        if (!remove) {
            System.out.println("Dish " + dishname + " not found");
        }
    }

    public void updateprice(String dishname, double price) {
        boolean update = false;
        for (Dish dish : dishs) {
            if (dish.getName().equals(dishname))
             //   dish.setPrice(price);
            System.out.println("Price updated successfully for dish: " + dishname + "to" + price);
            update = true;
            break;
        }
        if (!update) {
            System.out.println("dish " + dishname + " not found");
        }
    }


    public void generateReport(ArrayList<Order> orders) {
        int totalOrders = orders.size();
        double totalsales = 0;


        for (Order order : orders) {
            totalsales += order.calculateTotalAmount();

        }


        System.out.println("=== Report ===");
        System.out.println("Total Orders: " + totalOrders);
        System.out.println("Total Sales :$ " + totalsales);

    }
    public ArrayList<Order> getOrders() {
        return orders;
    }

    public boolean login() {
        System.out.println("Enter Admin Username:");
        String inputUsername = scanner.next();
        System.out.println("Enter Admin Password:");
        String inputPassword = scanner.next();

        if (inputUsername.equals(this.AdminName) && inputPassword.equals(this.AdminPass)) {
            System.out.println("Admin login successful!");
            return true;
        } else {
            System.out.println("Invalid admin credentials.");
            return false;
        }
    }}