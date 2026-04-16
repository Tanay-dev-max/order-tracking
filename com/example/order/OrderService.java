package com.example.order;

import java.util.HashMap;
import java.util.Map;

public class OrderService {
    private Map<String, Order> orders = new HashMap<>();

    public Order placeOrder(String orderId, String customerName, String item) {
        if (item == null || item.isEmpty()) {
            throw new IllegalArgumentException("Item cannot be empty");
        }
        Order order = new Order(orderId, customerName, item);
        orders.put(orderId, order);
        return order;
    }

    public void updateOrderStatus(String orderId, String status) {
        Order order = orders.get(orderId);
        if (order == null) {
            throw new IllegalArgumentException("Order not found");
        }
        order.updateStatus(status);
    }

    public String trackOrder(String orderId) {
        Order order = orders.get(orderId);
        if (order == null) {
            return "Order not found";
        }
        return order.getStatus();
    }
}
