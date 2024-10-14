package com.omartahri.billing_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.omartahri.billing_service.model.Customer;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE", url = "http://localhost:8888/CUSTOMER-SERVICE")
public interface CustomerRestClientService {
    @GetMapping(path = "/customers/{id}")
    Customer getCustomerById(@PathVariable Long id);

    @GetMapping(path = "/customers")
    List<Customer> getCustomers();

}
