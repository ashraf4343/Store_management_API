package com.siprogramming.restapi.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siprogramming.restapi.repositories.OrderRepository;

import java.time.LocalDate;


//http://localhost:8080/api/sale/total-amount-current-day
@RestController
@RequestMapping("/api/sale")
public class SaleController {

    private final Logger logger = LoggerFactory.getLogger(SaleController.class);

    @Autowired
    private OrderRepository orderRepository;

    // API to return the total sale amount of the current day
    @GetMapping("/total-amount-current-day")
    public ResponseEntity<Double> getTotalSaleAmountForCurrentDay() {
        try {
            LocalDate currentDate = LocalDate.now();

            Double totalSaleAmount = orderRepository.findTotalSaleAmountByOrderDate(currentDate);

            return ResponseEntity.ok(totalSaleAmount != null ? totalSaleAmount : 0.0);
        } catch (Exception e) {
          
            logger.error("An error occurred while processing the request", e);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

   
}

