package org.sid.bank_service.mappers;

import org.sid.bank_service.dtos.BankAccountDTO;
import org.sid.bank_service.entities.BankAccount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BankAccountMapper {
    BankAccountMapper INSTANCE = Mappers.getMapper(BankAccountMapper.class);

    BankAccountDTO toDto(BankAccount bankAccount);

    BankAccount toEntity(BankAccountDTO bankAccountDTO);

    List<BankAccountDTO> toDtoList(List<BankAccount> bankAccounts);

}