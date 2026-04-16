package com.example.order;

public class OrderServiceTestRunner {
    public static void main(String[] args) {
        OrderService service = new OrderService();

        // Test 1: Place order success
        Order order1 = service.placeOrder("1", "Alice", "Laptop");
        System.out.println("Test 1: " + (order1.getStatus().equals("PLACED") ? "PASS" : "FAIL"));

        // Test 2: Place order failure
        try {
            service.placeOrder("2", "Bob", "");
            System.out.println("Test 2: FAIL");
        } catch (IllegalArgumentException e) {
            System.out.println("Test 2: PASS");
        }

        // Test 3: Update order status
        service.placeOrder("3", "Charlie", "Phone");
        service.updateOrderStatus("3", "SHIPPED");
        System.out.println("Test 3: " + (service.trackOrder("3").equals("SHIPPED") ? "PASS" : "FAIL"));

        // Test 4: Track order not found
        System.out.println("Test 4: " + (service.trackOrder("999").equals("Order not found") ? "PASS" : "FAIL"));
    }
}
