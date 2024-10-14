package com.omartahri.billing_service.model;

import lombok.Data;

@Data
public class Customer {
    private Long Id;
    private String name;
    private String lastName;
    private String email;
}
