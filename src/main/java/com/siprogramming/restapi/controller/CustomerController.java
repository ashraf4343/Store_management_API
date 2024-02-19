package com.siprogramming.restapi.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siprogramming.restapi.entity.Customer;
import com.siprogramming.restapi.repositories.CustomerRepository;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    // API to return all of the registered customer list
    
    //http://localhost:8080/api/customers/registered
    
    @GetMapping("/registered")
    public List<Customer> getRegisteredCustomers() {
        return customerRepository.findAll();
    }
    
    
    
    
}
