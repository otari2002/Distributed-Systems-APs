package org.sid.bank_service;

import lombok.RequiredArgsConstructor;
import org.sid.bank_service.entities.BankAccount;
import org.sid.bank_service.enums.AccountType;
import org.sid.bank_service.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;


@SpringBootApplication
@RequiredArgsConstructor
public class BankServiceApplication {
	private final BankAccountRepository bankAccountRepository;

	public static void main(String[] args) {
		SpringApplication.run(BankServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(){
		return args -> {
			for (int i = 0; i < 10; i++) {
				double randomBalance = Math.round((1000 + Math.random()*1000) * 100.0) / 100.0;
				BankAccount bankAccount = BankAccount.builder()
					.id(UUID.randomUUID().toString())
					.createdAt(new Date())
					.balance(randomBalance)
					.currency("MAD")
					.accountType(Math.random()> 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
					.build();
				bankAccountRepository.save(bankAccount);
			}
		};
	}
}
