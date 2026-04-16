package src.main.java.com.example.order;

public class Order {
    private final String orderId;
    private final String customerName;
    private final String item;
    private String status;

    public Order(String orderId, String customerName, String item) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.item = item;
        this.status = "PLACED";
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getItem() {
        return item;
    }
}
