
import java.util.*;
public  class User extends Vaildation {
    private static final String EMAIL = "^[a-zA-Z0-9_+&-]+(?:\\.[a-zA-Z0-9_+&-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
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

    public void setPassword() {
        this.Password = Password;
    }

    public String geTPassword() {
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
        boolean vaild = false;
        System.out.print("  Username :");
        username = scanner.next();
        System.out.print("  Email : ");
        Email = scanner.next();
        vaildemail(Email);
        while (!vaildemail(Email)) {
            System.out.println("Invaild Email");
            System.out.println("Try again");
            System.out.print(" Enter Email :");
            Email = scanner.next();

        }
        System.out.println(" Password");
        System.out.print(" Enter Atleast 8 charactors :");
        Password = scanner.next();
        System.out.print("   Address :");
        Address = scanner.next();
        if (Email.isEmpty()) {
            System.out.println(" Invaild Password ");
            if (Password.isEmpty())
                System.out.println(" Invaild Password ");
            if (username.equals(username)) {
                System.out.println("Username already taken.");

            }


        }

        System.out.println(" Register Completed !!!");
        return new User();
    }

    public boolean login() {
        System.out.print("Enter username :");
        String CorrectUsername = scanner.next();
        System.out.print("Enter Password :");
        String  CorrectPassword= scanner.next();

        boolean stat = false;
        do {

            if (CorrectUsername.equals(username) && CorrectPassword.equals(Password)) {
                System.out.println("Login successful !!!");
                stat = true;
            } else {
                System.out.println("Invaild username or password ");
                System.out.println("try again ");
            }
        } while (stat = false);

        return true;
    }

    public boolean update(String newEmail, String newAddress) {
        boolean updated = false;
        this.Email = newEmail;
        this.Address = newAddress;
        System.out.print("Enter new Email : ");
        newEmail = scanner.next();
        vaildemail(newEmail);
        while (!vaildemail(Email)) {
            System.out.println("Invaild Email");
            System.out.println("Try again");
            System.out.print(" Enter new Email :");
            Email = scanner.next();
        }
        System.out.print("Enter new Address : ");
        newAddress = scanner.next();
        if (newEmail.isEmpty()) {
            System.out.println("Error: Email cannot be empty.");
        } else {
            this.Email = newEmail;
            updated = true;

        }
        if (newAddress.isEmpty()) {
            System.out.println("Error: Delivery address cannot be empty.");
        } else {
            this.Address = newAddress;
            updated = true;
        }
        if (updated) {
            System.out.println(" Profile updated successfully.");
        } else {
            System.out.println(" Profile update failed. No changes were made.");
        }
        return updated;
    }

    public void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println(" No previous orders yet.");
        } else {
            for (Order order : orders) {
                order.viewOrderDetails();
            }
        }
    }
}
