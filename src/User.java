
import java.util.*;
public class User {

    Scanner scanner = new Scanner(System.in);
    protected String username;
    private String Password;
    private String Email;
    private String Address;
    private int Phonenum;
    private ArrayList<Order> orders;

    public User() {

        this.username = username;
        this.Password = Password;
        this.Email = Email;
        this.Address = Address;
        this.Phonenum = Phonenum;
        orders = new ArrayList<>();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getusername() {
        return username;
    }

    public void setU_password() {
        this.Password = Password;
    }

    public String getU_password() {
        return Password;

    }

    public void setEmail() {
        this.Email = Email;
    }

    public String getEmail() {
        return Email;
    }

    public void setAddress() {
        this.Address = Address;
    }

    public String getAddress() {
        return Address;
    }

    public void setPhonenum() {
        this.Phonenum = Phonenum;
    }

    public int getPhonenum() {
        return Phonenum;
    }


    public User Register() {

        System.out.println("username");
        username = scanner.next();
        System.out.println("Email ");
        Email = scanner.next();
        System.out.println("Password");
        System.out.println("Enter atleast 8 characters");
        Password = scanner.next();
        System.out.println("Address");
        Address = scanner.next();
        if (Email.isEmpty()) {
            System.out.println("Invail Passwprd ");
            if (Password.isEmpty())
                System.out.println("Invail Passwprd ");
            if (username.equals(username)) {
                System.out.println("Username already taken.");

            }

        }

        System.out.println(" Register Completed !!!");
        return new User();
    }

    public boolean login() {

        System.out.println("Enter username ");
        String correct_username = scanner.next();
        System.out.println("Enter Password");
        String correct_password = scanner.next();
        boolean stat = false;
        do {

            if (correct_username.equals(username) && correct_password.equals(Password)) {
                System.out.println("Login successful");
                stat = true;
            } else {
                System.out.println("Invild username or password ");
                System.out.println("try again ");
            }
        } while (stat = false);

        return true;
    }

    public boolean update(String newEmail, String newAddress) {
        boolean up = false;
        this.Email = newEmail;
        this.Address = newAddress;
        if (newEmail.isEmpty()) {
            System.out.println("Error: Email cannot be empty.");
        } else {
            this.Email = newEmail;
            up = true;
            System.out.println("Profile updated successfully.");
        }
        if (newAddress.isEmpty()) {
            System.out.println("Error: Delivery address cannot be empty.");
        } else {
            this.Address = newAddress;
            up = true;
        }
        if (up) {
            System.out.println("Information updated successfully.");
        } else {
            System.out.println("Information update failed. No changes were made.");
        }

        return up;
    }

    public void viewOrders() {
        if (orders.isEmpty())
        {
            System.out.println("No previous orders yet.");
        } else {
            for (Order order : orders) {
                order.viewOrderDetails();
            }
        }

    }

}
