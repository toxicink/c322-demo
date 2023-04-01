package edu.iu.c322.customerservice.repository;

import edu.iu.c322.customerservice.model.Customer;
import edu.iu.c322.customerservice.model.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> findByCustomerId(int customerId);
    int create(Order order);
    void updateOrderItemStatus(int orderId, int orderItemId, String newStatus);
    void cancelOrder(int orderId);
}
