import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
enum OrderStatus {
        IN_PROGRESS,
        PAID,
        PREPARING,
        DELIVERED
}
class Order {
        private static int orderCounter = 0;
        private int orderId;
        private ArrayList<CartItem> items;
        private OrderStatus status;
        private String deliveryAddress;
        private double totalAmount;

        // Constructor
        public Order() {
                Cart cart = new Cart();
                this.orderId = ++orderCounter;
                this.items = new ArrayList<>();
                this.status = OrderStatus.IN_PROGRESS;
               this.totalAmount = cart.gettotalPrice() ;
        }


        public void placeOrder(ArrayList<CartItem> items ) {
                Cart cart = new Cart();
                this.items = items;
                System.out.println("Amount:" + cart.gettotalPrice());
               //calculateTotalAmount();

                // Request delivery address
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter your delivery address: ");
                this.deliveryAddress = scanner.nextLine();
        }

        //  update the status of the order
        public void updateStatus(OrderStatus newStatus) {
                this.status = newStatus;
                System.out.println("Order status updated to: " + newStatus);
        }

        //  view the order details
        public void viewOrderDetails() {
                Cart cart = new Cart();
                System.out.println("Order ID: " + orderId);
                System.out.println("Status: " + status);
                System.out.println("Delivery Address: " + deliveryAddress);
                System.out.println("Items in Order:");
                for (CartItem item : items) {
                        System.out.println("- " + item.getDish().getName() + " (" + item.getQuantity() + "): $" + item.getDish().getPrice() + " each");
                }
                System.out.println("Total Amount: $" +cart.gettotalPrice() );
        }

        // Method to calculate total amount
        public double calculateTotalAmount() {
                totalAmount = 0.0;
                for (CartItem item : items) {
                        totalAmount += item.getSubtotal();
                }
                return totalAmount;
        }

        // Method to process payment
        public boolean processPayment() {
                Scanner scanner = new Scanner(System.in);

                // Ask user for payment method
                System.out.println("Choose a payment method:");
                System.out.println("1. Credit Card");
                System.out.println("2. Digital Wallet");
                int choice = scanner.nextInt();

                Payment.PaymentMethod selectedMethod;
                if (choice == 1) {
                        selectedMethod = Payment.PaymentMethod.CREDIT_CARD;
                } else if (choice == 2) {
                        selectedMethod = Payment.PaymentMethod.DIGITAL_WALLET;
                } else {
                        System.out.println("Invalid choice. Payment failed.");
                        return false;
                }


                Payment payment = new Payment(selectedMethod, null, "Pending");
                boolean success = payment.processPayment(totalAmount);


                if (success) {
                        updateStatus(OrderStatus.PAID);
                        scheduleOrderStatusChange(); // Start status change process
                } else {
                        System.out.println("Payment failed. Please try again.");
                }

                return success;
        }

        public String getDeliveryAddress() {
                return deliveryAddress;
        }

        // Method to schedule automatic status changes after payment
        public void scheduleOrderStatusChange() {
                ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);


                scheduler.schedule(() -> {
                        updateStatus(OrderStatus.PREPARING);
                        scheduler.schedule(() -> {
                                updateStatus(OrderStatus.DELIVERED);
                                System.out.println("Order completed successfully!");
                        }, 5, TimeUnit.SECONDS);
                }, 5, TimeUnit.SECONDS);
        }

        public double getTotalAmount() {
                return totalAmount;
        }
}
