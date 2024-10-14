package com.omartahri.billing_service.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.omartahri.billing_service.entities.Bill;
import com.omartahri.billing_service.repository.BillRepository;
import com.omartahri.billing_service.service.CustomerRestClientService;
import com.omartahri.billing_service.service.InventoryRestClientService;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BillRestController {
    private final BillRepository billRepository;
    private final CustomerRestClientService customerRestClientService;
    private final  InventoryRestClientService inventoryRestClientService;

     @GetMapping("/fullBill/{id}")
    public Bill getFullBill(@PathVariable Long id) {
         Bill bill = billRepository.findById(id).get();
         bill.setCustomer(customerRestClientService.getCustomerById(bill.getCustomerId()));
         bill.getProductItems().forEach(pi -> {
             pi.setProduct(inventoryRestClientService.getProductById(pi.getProductId()));
             pi.setProduct(pi.getProduct());
         });
         return bill;
     }
    @GetMapping("/bills")
    public List<Bill> getBills() {
         List<Bill> bills = billRepository.findAll();
         bills.forEach(bill -> {
             bill.setCustomer(customerRestClientService.getCustomerById(bill.getCustomerId()));
             bill.getProductItems().forEach(pi -> {
                 pi.setProduct(inventoryRestClientService.getProductById(pi.getProductId()));
             });
         });
         return bills;
     }

}
