package com.siprogramming.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.siprogramming.restapi.entity.Customer;
import com.siprogramming.restapi.entity.Order;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomer(Customer customer);

    List<Order> findByOrderDate(LocalDate orderDate);

  
    LocalDate findTopByOrderDateBetweenOrderByOrderDateDesc(LocalDate startDate, LocalDate endDate);
    
    List<Order> findByCustomer_Id(Long customerId);


    
    @Query("SELECT o.orderDate FROM Order o WHERE o.orderDate BETWEEN :startDate AND :endDate " +
            "GROUP BY o.orderDate ORDER BY COUNT(o.orderDate) DESC, o.orderDate DESC")
    List<LocalDate> findMaxSaleDayInTimeRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);


    @Query("SELECT SUM(o.amount) FROM Order o WHERE o.orderDate = :orderDate")
    Double findTotalSaleAmountByOrderDate(@Param("orderDate") LocalDate orderDate);
}

