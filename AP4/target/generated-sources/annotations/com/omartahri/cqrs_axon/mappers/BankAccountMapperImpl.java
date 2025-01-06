package com.omartahri.cqrs_axon.mappers;

import com.omartahri.cqrs_axon.queries.dto.AccountOperationResponseDTO;
import com.omartahri.cqrs_axon.queries.dto.BankAccountResponseDTO;
import com.omartahri.cqrs_axon.queries.entities.AccountOperation;
import com.omartahri.cqrs_axon.queries.entities.BankAccount;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-06T18:17:13+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class BankAccountMapperImpl implements BankAccountMapper {

    @Override
    public BankAccountResponseDTO bankAccountToBankAccountDTO(BankAccount bankAccount) {
        if ( bankAccount == null ) {
            return null;
        }

        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();

        bankAccountResponseDTO.setBalance( bankAccount.getBalance() );
        bankAccountResponseDTO.setId( bankAccount.getId() );
        bankAccountResponseDTO.setStatus( bankAccount.getStatus() );

        return bankAccountResponseDTO;
    }

    @Override
    public AccountOperationResponseDTO accountOperationToAccountOperationDTO(AccountOperation accountOperation) {
        if ( accountOperation == null ) {
            return null;
        }

        AccountOperationResponseDTO accountOperationResponseDTO = new AccountOperationResponseDTO();

        accountOperationResponseDTO.setAmount( accountOperation.getAmount() );
        accountOperationResponseDTO.setId( accountOperation.getId() );
        accountOperationResponseDTO.setOperationDate( accountOperation.getOperationDate() );
        accountOperationResponseDTO.setType( accountOperation.getType() );

        return accountOperationResponseDTO;
    }
}
