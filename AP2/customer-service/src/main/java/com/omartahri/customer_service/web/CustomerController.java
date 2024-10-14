package com.omartahri.customer_service.web;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.omartahri.customer_service.entity.Customer;
import com.omartahri.customer_service.repository.CustomerRepository;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return customerRepository.findById(id).orElse(null);
    }

}
