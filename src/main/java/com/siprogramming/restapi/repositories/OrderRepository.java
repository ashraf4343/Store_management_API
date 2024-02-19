package com.siprogramming.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.siprogramming.restapi.entity.Customer;
import com.siprogramming.restapi.entity.Order;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.siprogramming.restapi.entity.Customer;
import com.siprogramming.restapi.entity.Order;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomer(Customer customer);

    List<Order> findByOrderDate(LocalDate orderDate);

  
    LocalDate findTopByOrderDateBetweenOrderByOrderDateDesc(LocalDate startDate, LocalDate endDate);
    
    List<Order> findByCustomer_Id(Long customerId);


    
 
    
 
    Double findTotalSaleAmountByOrderDate(LocalDate orderDate);
}

