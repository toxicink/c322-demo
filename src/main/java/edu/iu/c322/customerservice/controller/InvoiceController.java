package edu.iu.c322.customerservice.controller;

import edu.iu.c322.customerservice.model.Customer;
import edu.iu.c322.customerservice.model.Invoice;
import edu.iu.c322.customerservice.model.Order;
import edu.iu.c322.customerservice.repository.CustomerRepository;
import edu.iu.c322.customerservice.repository.InMemoryCustomerRepository;
import edu.iu.c322.customerservice.repository.InvoiceRepository;
import edu.iu.c322.customerservice.repository.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    private InvoiceRepository invoiceRepository;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/{orderId}")
    public Invoice getInvoiceByOrderId(@PathVariable int orderId) {
        return invoiceRepository.findByOrderId(orderId);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{orderId}")
    public void updateOrderItemStatus(@PathVariable int orderId, @PathVariable int itemId, @RequestBody String newStatus) {
        invoiceRepository.updateOrderItemStatus(orderId, itemId, newStatus);
    }
}
