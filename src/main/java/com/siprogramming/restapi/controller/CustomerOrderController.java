package com.siprogramming.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siprogramming.restapi.entity.Order;
import com.siprogramming.restapi.repositories.OrderRepository;

import java.util.List;

@RestController
@RequestMapping("/api/customer-orders")
public class CustomerOrderController {

    @Autowired
    private OrderRepository orderRepository;

    //  to return entire order list of a customer
    
    
    //http://localhost:8080/api/customer-orders/customer/1
    
    @GetMapping("/customer/{customerId}")
    public List<Order> getOrdersByCustomer(@PathVariable Long customerId) {
        return orderRepository.findByCustomer_Id(customerId);
    }
}
