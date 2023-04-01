package edu.iu.c322.customerservice.controller;

import edu.iu.c322.customerservice.model.Customer;
import edu.iu.c322.customerservice.model.Order;
import edu.iu.c322.customerservice.model.Tracking;
import edu.iu.c322.customerservice.repository.CustomerRepository;
import edu.iu.c322.customerservice.repository.InMemoryCustomerRepository;
import edu.iu.c322.customerservice.repository.OrderRepository;
import edu.iu.c322.customerservice.repository.TrackingRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trackings")
public class TrackingController {
    private TrackingRepository trackingRepository;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/{orderId}/{itemId}")
    public Tracking getTrackingOrder(@Valid @PathVariable int orderId,@Valid @PathVariable int itemId) {
        return trackingRepository.findByOrderANDItemId(orderId, itemId);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{orderId}")
    public String updateOrderItemStatus(@PathVariable int orderId, @PathVariable int itemId, @RequestBody String newStatus) {
        return trackingRepository.updateOrderItemStatus(orderId, itemId, newStatus);
    }
}
