package com.siprogramming.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

import com.siprogramming.restapi.entity.Order;
import com.siprogramming.restapi.repositories.OrderRepository;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

 

    // to return order list of the current day
    
    //http://localhost:8080/api/orders/current-day
    @GetMapping("/current-day")
    public List<Order> getCurrentDayOrders() {
        LocalDate currentDate = LocalDate.now();
        return orderRepository.findByOrderDate(currentDate);
    }
}