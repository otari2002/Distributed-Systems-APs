package com.omartahri.cqrs_axon.events;

import com.omartahri.cqrs_axon.enums.AccountStatus;
import lombok.Getter;

import java.math.BigDecimal;
public class AccountCreatedEvent extends BaseEvent<String> {
    @Getter private final BigDecimal balance;
    @Getter private final String currency;
    @Getter private final AccountStatus status;

    public AccountCreatedEvent(String id, BigDecimal balance, String currency, AccountStatus status) {
        super(id);
        this.balance = balance;
        this.currency = currency;
        this.status = status;
    }
}
