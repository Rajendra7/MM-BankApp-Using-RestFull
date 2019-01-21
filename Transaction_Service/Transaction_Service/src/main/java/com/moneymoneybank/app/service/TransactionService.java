package com.moneymoneybank.app.service;

import java.time.LocalDate;
import java.util.List;

import com.moneymoneybank.app.entity.Transaction;

public interface TransactionService {
	List<Transaction> getStatement(LocalDate startDate, LocalDate endDate);

	Double withdraw(int accountNumber, String transactioDetails, double currentBalance, double amount);

	Double deposit(int accountNumber, String transactioDetails, double currentBalance, double amount);

	Double[] fundTransfer(int senderAccountNumber, String transactioDetails, double currentBalance,
			int recieverAccountNumber, double amount);

}