package edu.iu.c322.customerservice.controller;

import edu.iu.c322.customerservice.model.Customer;
import edu.iu.c322.customerservice.model.Order;
import edu.iu.c322.customerservice.repository.CustomerRepository;
import edu.iu.c322.customerservice.repository.InMemoryCustomerRepository;
import edu.iu.c322.customerservice.repository.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderRepository orderRepository;

    @GetMapping("/{customerId}")
    public List<Order> getOrdersByCustomerId(@PathVariable int customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    @PostMapping
    public int createOrder(@Valid @RequestBody Order order) {
        return orderRepository.create(order);
    }

    @PutMapping("/return")
    public void updateOrderItemStatus(@Valid @PathVariable int orderId, @PathVariable int itemId, @RequestBody String newStatus) {
        orderRepository.updateOrderItemStatus(orderId, itemId, newStatus);
    }

    @DeleteMapping("/{orderId}")
    public void cancelOrder(@PathVariable int orderId) {
        orderRepository.cancelOrder(orderId);
    }
}

