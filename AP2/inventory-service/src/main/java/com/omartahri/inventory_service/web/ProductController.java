package com.omartahri.inventory_service.web;


import com.omartahri.inventory_service.entity.Product;
import com.omartahri.inventory_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {
    private final ProductRepository productRepository;
    @GetMapping("/products")
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Long id){
        return productRepository.findById(id).orElse(null);
    }

}
