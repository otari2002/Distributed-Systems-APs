package org.sid.bank_service.service;

import org.sid.bank_service.dtos.BankAccountDTO;
import org.sid.bank_service.entities.BankAccount;
import org.sid.bank_service.exceptions.AccountNotFoundException;

import java.util.List;

public interface IBankAccountService {
    List<BankAccountDTO> getAllAccounts();
    BankAccountDTO getAccountById(String id) throws AccountNotFoundException;
    BankAccountDTO createAccount(BankAccountDTO account);
    BankAccountDTO updateAccount(BankAccountDTO account) throws AccountNotFoundException;
    void deleteAccount(String id);
}
