package org.sid.bank_service.dtos;

import lombok.*;
import org.sid.bank_service.enums.AccountType;

import java.util.Date;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class BankAccountDTO {
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    private AccountType accountType;
}
