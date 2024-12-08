import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Order {
        private static int orderCounter = 0;
        private int orderId;
        private ArrayList<CartItem> items;
        private String status;
        private String deliveryAddress;
        private double totalAmount;

        public Order() {
                this.orderId = ++orderCounter;
                this.items = new ArrayList<>();
                this.status = "In Progress";
                this.totalAmount = 0.0;
        }

        // Place an order with items and delivery address
        public void placeOrder(ArrayList<CartItem> items, String deliveryAddress) {
                this.items = items;
                this.deliveryAddress = deliveryAddress;
                calculateTotalAmount();
                startOrderProcess();
        }

        // Update the status of the order
        public void updateStatus(String newStatus) {
                this.status = newStatus;
        }

        // Calculate total amount for the order
        public double calculateTotalAmount() {
                totalAmount = 0.0;
                for (CartItem item : items) {
                        totalAmount += item.getSubtotal();
                }
                return totalAmount;
        }

        // Method to simulate the order process with status updates every 5 seconds
        public void startOrderProcess() {
                ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

                // Runnable task that updates order status every 5 seconds
                Runnable statusUpdater = new Runnable() {
                        @Override
                        public void run() {
                                switch (status) {
                                        case "In Progress":
                                                updateStatus("Preparing");
                                                System.out.println("Status updated to: " + status);
                                                break;
                                        case "Preparing":
                                                updateStatus("Out for Delivery");
                                                System.out.println("Status updated to: " + status);
                                                break;
                                        case "Out for Delivery":
                                                updateStatus("Delivered");
                                                System.out.println("Status updated to: " + status);
                                                scheduler.shutdown(); // Stop the scheduler once the order is delivered
                                                break;
                                        default:
                                                break;
                                }
                        }
                };

                // Schedule the task to run every 5 seconds (first run after 5 seconds)
                scheduler.scheduleAtFixedRate(statusUpdater, 5, 5, TimeUnit.SECONDS);
        }

        // View details of the order
        public void viewOrderDetails() {
                System.out.println("Order ID: " + orderId);
                System.out.println("Status: " + status);
                System.out.println("Delivery Address: " + deliveryAddress);
                System.out.println("Items in Order:");
                for (CartItem item : items) {
                        System.out.println("- " + item.getDish() + ": $" + item.getDishPrice());
                }
                System.out.println("Total Amount: $" + totalAmount);
        }

        public double getTotalAmount() {
                return totalAmount;
        }
}
