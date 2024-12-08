
import java.util.ArrayList;


public class Admin {
    private String AdminName;
    private String AdminPass;
    private ArrayList<Restaurant> restaurants;
    private ArrayList<Order> orders;

    public Admin(String AdminName, String AdminPass) {
        this.AdminName = AdminName;
        this.AdminPass = AdminPass;
        this.restaurants = new ArrayList<>();
        this.orders=new ArrayList<>();
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


    public void addrestaurant (Restaurant rest )
    {
        if (rest != null)
        {
            restaurants.add(rest);
            System.out.println("Restaurant "+ rest.getName() +"adedd successfully");
        }else
        {
            System.out.println("restaurant not added");
        }
    }

    public void removeRestaurant(String restname)
    {
        boolean remove= false;
        for(int i=0 ;i<restaurants.size();i++)
        {
            if (restaurants.get(i).getName().equals(restname))
            {
                restaurants.remove(i);
                System.out.println("Restaurant "+restname+"has been successfuly deleted");
                remove=true;
                break;
            }
        }
        if (!remove)
        {
            System.out.println("Restaurant " + restname + "not found");
        }
    }
    public void viewAllOrders()
    {
        if (orders.isEmpty())
        {
            System.out.println("no order available");

        } else
        {
            System.out.println("all orders");
            for (Order ord : orders)
            {
                System.out.println(ord);
            }
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
        System.out.println("Total Sales :$ " + totalsales );

    }
}
