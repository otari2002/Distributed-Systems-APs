package com.omartahri.customer_service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import com.omartahri.customer_service.entity.Customer;
import com.omartahri.customer_service.repository.CustomerRepository;

@SpringBootApplication
@RequiredArgsConstructor
@EnableDiscoveryClient

public class CustomerServiceApplication {
	private  final CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(){
		return args -> {
			customerRepository.save(new Customer(null,"Omar","Tahri","omar@gmail.com"));
			customerRepository.save(new Customer(null,"Otari","Tahri","otari@gmail.com"));
		};
	}
}
