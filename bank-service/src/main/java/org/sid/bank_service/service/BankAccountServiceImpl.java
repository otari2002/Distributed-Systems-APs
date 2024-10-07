package org.sid.bank_service.service;

import org.sid.bank_service.dtos.BankAccountDTO;
import org.sid.bank_service.entities.BankAccount;
import org.sid.bank_service.exceptions.AccountNotFoundException;
import org.sid.bank_service.mappers.BankAccountMapper;
import org.sid.bank_service.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BankAccountServiceImpl implements IBankAccountService {
    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    private final BankAccountRepository bankAccountRepository;
    @Override
    public List<BankAccountDTO> getAllAccounts() {
        List<BankAccount> accounts = bankAccountRepository.findAll();
        return BankAccountMapper.INSTANCE.toDtoList(accounts);
    }

    @Override
    public BankAccountDTO getAccountById(String id) throws AccountNotFoundException {
        BankAccount bankAccount = bankAccountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        return BankAccountMapper.INSTANCE.toDto(bankAccount);
    }

    @Override
    public BankAccountDTO createAccount(BankAccountDTO account) {
        BankAccount bankAccount = BankAccountMapper.INSTANCE.toEntity(account);
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount = bankAccountRepository.save(bankAccount);
        return BankAccountMapper.INSTANCE.toDto(bankAccount);
    }

    @Override
    public BankAccountDTO updateAccount(BankAccountDTO account) throws AccountNotFoundException {
        BankAccount bankAccount = bankAccountRepository.findById(account.getId()).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        if(account.getBalance() != null) {
            bankAccount.setBalance(account.getBalance());
        }
        if(account.getCurrency() != null) {
            bankAccount.setCurrency(account.getCurrency());
        }
        if(account.getAccountType() != null) {
            bankAccount.setAccountType(account.getAccountType());
        }
        if (account.getCreatedAt() != null) {
            bankAccount.setCreatedAt(account.getCreatedAt());
        }
        bankAccountRepository.save(bankAccount);
        return BankAccountMapper.INSTANCE.toDto(bankAccount);
    }

    @Override
    public void deleteAccount(String id) {
        bankAccountRepository.deleteById(id);
    }
}
