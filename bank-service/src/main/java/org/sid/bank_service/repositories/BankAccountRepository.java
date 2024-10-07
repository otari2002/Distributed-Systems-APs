package org.sid.bank_service.repositories;

import org.sid.bank_service.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface BankAccountRepository extends JpaRepository<BankAccount, String>{
}
