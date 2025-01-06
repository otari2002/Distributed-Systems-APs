package com.omartahri.cqrs_axon.queries.repository;

import com.omartahri.cqrs_axon.queries.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
