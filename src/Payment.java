import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
//java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


class Payment {
    enum PaymentMethod {
        CREDIT_CARD,
        DIGITAL_WALLET
    }

    private PaymentMethod paymentMethod;
    private String transactionId;
    private String paymentStatus;

    public Payment(PaymentMethod paymentMethod, String transactionId, String paymentStatus) {
        this.paymentMethod = paymentMethod;
        this.transactionId = transactionId;
        this.paymentStatus = paymentStatus;
    }

    public boolean processPayment(double amount) {
        try {
            ArrayList <CartItem> cartItems = new ArrayList<>();
            Order order = new Order();
           // LocalDateTime currentTime = LocalDateTime.now();
           // LocalDateTime newTime = currentTime.plusMinutes(30);

            System.out.println("Processing payment...");
            order.placeOrder(cartItems);
          //  System.out.println("Amount: $" + amount);
            System.out.println("Payment Method: " + paymentMethod);
            DateTimeFormatter time = DateTimeFormatter.ofPattern( " HH:mm ")  ;
          //  System.out.println("your order will arrive at " + newTime.format(formatter));

            System.out.println("Delivery Address: " + order.getDeliveryAddress());
            if (paymentMethod == PaymentMethod.CREDIT_CARD) {
                System.out.println("Processing payment via Credit/Debit Card...");
            } else if (paymentMethod == PaymentMethod.DIGITAL_WALLET) {
                System.out.println("Processing payment via Digital Wallet...");
            } else {
                throw new Exception("Unsupported payment method");
            }

            long currentTimeMillis = System.currentTimeMillis();
            int randomNumber = new Random().nextInt(10000);
            this.transactionId = "TXN" + currentTimeMillis + "-" + randomNumber;
            this.paymentStatus = "Success";

            System.out.println("Payment Successful! Transaction ID: " + transactionId);
            return true;
        } catch (Exception e) {
            this.paymentStatus = "Failed";
            System.out.println("Payment failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentMethod=" + paymentMethod +
                ", transactionId='" + transactionId + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}