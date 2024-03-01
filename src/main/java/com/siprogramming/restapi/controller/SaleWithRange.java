package com.siprogramming.restapi.controller;


import java.time.LocalDate;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;  // Add RestController annotation
import com.siprogramming.restapi.repositories.OrderRepository;


//http://localhost:8080/max-sale-day?startDate=2024-01-01&endDate=2024-12-31

@RestController  
public class SaleWithRange {

    private static final Logger logger = LoggerFactory.getLogger(SaleWithRange.class);

    @Autowired
    private OrderRepository orderRepository;
 
    @GetMapping("/max-sale-day")
    public ResponseEntity<LocalDate> getMaxSaleDayInTimeRange(
            @RequestParam("startDate") LocalDate startDate,
            @RequestParam("endDate") LocalDate endDate) {
        try {
            List<LocalDate> maxSaleDays = orderRepository.findMaxSaleDayInTimeRange(startDate, endDate);

            if (!maxSaleDays.isEmpty()) {
                LocalDate maxSaleDay = maxSaleDays.get(0);
                return ResponseEntity.ok(maxSaleDay);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            logger.error("An error occurred while processing the request", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
