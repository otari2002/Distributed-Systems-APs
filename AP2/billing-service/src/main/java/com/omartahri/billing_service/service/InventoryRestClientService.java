package com.omartahri.billing_service.service;

import com.omartahri.billing_service.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "PRODUCT-SERVICE", url = "http://localhost:8888/PRODUCT-SERVICE")
public interface InventoryRestClientService {
    @GetMapping("/products")
    List<Product> getProducts();
    @GetMapping("/products/{id}")
    Product getProductById(Long id);
}
