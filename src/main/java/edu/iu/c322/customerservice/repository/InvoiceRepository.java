package edu.iu.c322.customerservice.repository;

import edu.iu.c322.customerservice.model.Customer;
import edu.iu.c322.customerservice.model.Invoice;
import edu.iu.c322.customerservice.model.Order;

import java.util.List;

public interface InvoiceRepository {
    Invoice findByOrderId(int orderId);
    void updateOrderItemStatus(int orderId, int itemId, String newStatus);
}
