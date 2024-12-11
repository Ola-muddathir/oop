import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.function.Predicate;

class Menu {
    private String menuName;
    private ArrayList<Dish> dishes;

    public Menu(String menuName) {
        this.menuName = menuName;
        this.dishes = new ArrayList<>();
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public void removeDish(String dishName) {
        dishes.removeIf(dish -> dish.getName().equalsIgnoreCase(dishName));
    }

    public void searchDish() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Search by:");
        System.out.println("1. Name");
        System.out.println("2. Category");
        System.out.print("Choose an option (1/2): ");
        int searchOption = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter search value: ");
        String searchValue = scanner.nextLine().trim().toLowerCase();

        ArrayList<Dish> result = new ArrayList<>();

        switch (searchOption) {
            case 1:
                for (Dish dish : dishes) {
                    if (dish.getName().toLowerCase().contains(searchValue)) {
                        result.add(dish);
                    }
                }
                break;

            case 2:
                for (Dish dish : dishes) {
                    if (dish.getCategory().toLowerCase().contains(searchValue)) {
                        result.add(dish);
                    }
                }
                break;

            default:
                System.out.println("Invalid option. Please choose 1 or 2.");
                return;
        }


        if (result.isEmpty()) {
            System.out.println("No dishes found matching your search.");
        } else {
            System.out.println("Search results:");
            for (Dish dish : result) {
                System.out.println(dish.getDetails());
                System.out.println("--------------------");
            }
        }
    }

    public Dish[] getDishes()
 {
     return new Dish[0];
 }
    public void viewMenu() {
        System.out.println("Menu: " + menuName);
        if (dishes.isEmpty()) {
            System.out.println("No dishes available.");
        } else {
            for (Dish dish : dishes) {
                System.out.println(dish.getDetails());
                System.out.println("--------------------");
            }
        }
    }
}
