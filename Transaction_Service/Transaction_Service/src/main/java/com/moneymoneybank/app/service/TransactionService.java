package com.moneymoneybank.app.service;

import java.time.LocalDateTime;

public interface TransactionService {

	Double deposit(Integer accountNumber, Double amount, String transactionDetails, LocalDateTime transactionDate,
			Double currentBalance, String string);

	Double withdraw(Integer accountNumber, Double amount, String transactionDetails, LocalDateTime transactionDate,
			Double currentBalance, String string);

}