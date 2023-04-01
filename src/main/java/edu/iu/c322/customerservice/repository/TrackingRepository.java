package edu.iu.c322.customerservice.repository;

import edu.iu.c322.customerservice.model.Customer;
import edu.iu.c322.customerservice.model.Order;
import edu.iu.c322.customerservice.model.Tracking;

import java.util.List;

public interface TrackingRepository {
    Tracking findByOrderANDItemId(int orderId, int itemID);
    String updateOrderItemStatus(int orderId, int orderItemId, String newStatus);
}
