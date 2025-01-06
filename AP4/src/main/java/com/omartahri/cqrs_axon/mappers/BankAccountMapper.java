package com.omartahri.cqrs_axon.mappers;

import com.omartahri.cqrs_axon.queries.dto.AccountOperationResponseDTO;
import com.omartahri.cqrs_axon.queries.dto.BankAccountResponseDTO;
import com.omartahri.cqrs_axon.queries.entities.AccountOperation;
import com.omartahri.cqrs_axon.queries.entities.BankAccount;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankAccountMapper {
    BankAccountResponseDTO bankAccountToBankAccountDTO(BankAccount bankAccount);
    AccountOperationResponseDTO accountOperationToAccountOperationDTO(AccountOperation accountOperation);
}
