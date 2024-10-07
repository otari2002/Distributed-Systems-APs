package org.sid.bank_service.web;

import org.sid.bank_service.dtos.BankAccountDTO;
import org.sid.bank_service.service.IBankAccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/graphql/accounts")
public class AccountGraphQLController {
    private final IBankAccountService bankAccountService;

    public AccountGraphQLController(IBankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }
    @QueryMapping
    public List<BankAccountDTO> getAllAccounts() {
        return bankAccountService.getAllAccounts();
    }
    @QueryMapping
    public BankAccountDTO getAccountById(@Argument String id) {
        return bankAccountService.getAccountById(id);
    }

    @MutationMapping
    public BankAccountDTO createAccount(@Argument BankAccountDTO account) {
        return bankAccountService.createAccount(account);
    }

    @MutationMapping
    public BankAccountDTO updateAccount(@Argument BankAccountDTO account) {
        return bankAccountService.updateAccount(account);
    }

    @MutationMapping
    public void deleteAccount(@Argument String id) {
        bankAccountService.deleteAccount(id);
    }
}
