package com.omartahri.cqrs_axon.commands.services;

import com.omartahri.cqrs_axon.commands.dto.CreateAccountRequestDTO;
import com.omartahri.cqrs_axon.commands.dto.CreditAccountRequestDTO;
import com.omartahri.cqrs_axon.commands.dto.DebitAccountRequestDTO;

import java.util.concurrent.CompletableFuture;

public interface AccountCommandService {
    CompletableFuture<String> createAccount(CreateAccountRequestDTO accountRequestDTO);
    CompletableFuture<String> debitAccount(DebitAccountRequestDTO debitAccountRequestDTO);
    CompletableFuture<String> creditAccount(CreditAccountRequestDTO creditAccountRequestDTO);
}
