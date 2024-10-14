package com.omartahri.inventory_service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import com.omartahri.inventory_service.entity.Product;
import com.omartahri.inventory_service.repository.ProductRepository;


@SpringBootApplication
@EnableDiscoveryClient
@RequiredArgsConstructor
public class InventoryServiceApplication {
	private final ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(){
		return args -> {
			productRepository.save(Product.builder().name("Laptop").price(1500).quantity(10).build());
			productRepository.save(Product.builder().name("Printer").price(300).quantity(20).build());
			productRepository.save(Product.builder().name("Smartphone").price(800).quantity(30).build());
		};
	}
}
