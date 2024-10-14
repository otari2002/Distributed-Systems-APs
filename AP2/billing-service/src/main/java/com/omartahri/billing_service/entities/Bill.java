package com.omartahri.billing_service.entities;

import jakarta.persistence.*;
import lombok.*;
import com.omartahri.billing_service.enums.BillStatus;
import com.omartahri.billing_service.model.Customer;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter

public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private Long customerId;
    @Enumerated(EnumType.STRING)
    private BillStatus status;
    @OneToMany
    private List<ProductItem> productItems;
    @Transient
    private Customer customer;

}
