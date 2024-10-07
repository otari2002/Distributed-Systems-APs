package org.sid.bank_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.*;
import lombok.*;
import org.sid.bank_service.enums.TransactionType;


import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class AccountTransaction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    private double amount;
    @ManyToOne
    private BankAccount bankAccount;
}