package com.moneymoneybank.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.moneymoneybank.app.entity.CurrentAccount;
import com.moneymoneybank.app.entity.SavingsAccount;
import com.moneymoneybank.app.repo.AccountRepository;

@SpringBootApplication
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadInitialData(AccountRepository repo) {
		return (evt) -> {
			repo.save(new SavingsAccount(101, "Raj", true));
			repo.save(new SavingsAccount(102, "Grace", 10_000.00, true));
			repo.save(new SavingsAccount(103, "Winny", 12_000.00, false));
			repo.save(new CurrentAccount(104, "bhanu", 13_000.00, 2_000.00));
			repo.save(new CurrentAccount(105, "Robin", 15_000.00, 1_000.00));
			
		};
	}

}

