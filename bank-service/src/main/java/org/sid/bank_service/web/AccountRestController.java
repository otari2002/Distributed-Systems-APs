package org.sid.bank_service.web;

import org.sid.bank_service.dtos.BankAccountDTO;
import org.sid.bank_service.service.IBankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountRestController {
    private final IBankAccountService bankAccountService;

    public AccountRestController(IBankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping({"", "/"})
    public List<BankAccountDTO> getAllAccounts() {
        return bankAccountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public BankAccountDTO getAccountById(@PathVariable String id) {
        return bankAccountService.getAccountById(id);
    }

    @PostMapping({"", "/"})
    public BankAccountDTO createAccount(@RequestBody BankAccountDTO account) {
        return bankAccountService.createAccount(account);
    }

    @PutMapping({"", "/"})
    public BankAccountDTO updateAccount(@RequestBody BankAccountDTO account) {
        return bankAccountService.updateAccount(account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable String id) {
        bankAccountService.deleteAccount(id);
    }

}
