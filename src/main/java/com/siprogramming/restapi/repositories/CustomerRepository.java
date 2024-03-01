package com.siprogramming.restapi.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.siprogramming.restapi.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
