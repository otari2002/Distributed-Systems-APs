package com.omartahri.billing_service;

import com.omartahri.billing_service.entities.Bill;
import com.omartahri.billing_service.entities.ProductItem;
import com.omartahri.billing_service.enums.BillStatus;
import com.omartahri.billing_service.model.Customer;
import com.omartahri.billing_service.model.Product;
import com.omartahri.billing_service.repository.BillRepository;
import com.omartahri.billing_service.repository.ProductItemRepository;
import com.omartahri.billing_service.service.CustomerRestClientService;
import com.omartahri.billing_service.service.InventoryRestClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(
			BillRepository billRepository,
			ProductItemRepository productItemRepository,
			CustomerRestClientService customerRestClientService,
			InventoryRestClientService inventoryRestClientService
	){
		return args -> {
			List<Customer> customers = customerRestClientService.getCustomers();
			List<Product> products = inventoryRestClientService.getProducts();
			Random random = new Random();

			for (int i = 0; i < 20; i++) {
				Bill bill = new Bill();
				bill.setCustomerId(customers.get(random.nextInt(customers.size())).getId());
				bill.setCreatedAt(new Date());
				bill.setStatus(Math.random() < 0.5 ? BillStatus.IN_PROGRESS : BillStatus.COMPLETED);
				bill.setProductItems(new ArrayList<>());

				billRepository.save(bill);

				for (Product product : products) {
					ProductItem productItem = new ProductItem();
					productItem.setProductId(product.getId());
					productItem.setProduct(product);
					productItem.setPrice(product.getPrice());
					productItem.setQuantity(random.nextInt(100));
					productItem.setBill(bill);

					bill.getProductItems().add(productItem);

					productItemRepository.save(productItem);
				}

				billRepository.save(bill);
			}


		};
	}
}
