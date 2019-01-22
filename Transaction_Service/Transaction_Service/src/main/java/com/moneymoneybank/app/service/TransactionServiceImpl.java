package com.moneymoneybank.app.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moneymoneybank.app.entity.Transaction;
import com.moneymoneybank.app.entity.TransactionType;
import com.moneymoneybank.app.repo.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository repository;

	@Override
	public Double deposit(Integer accountNumber, Double amount, String transactionDetails,
			LocalDateTime transactionDate, Double currentBalance, String string) {
		Transaction transaction = new Transaction();

		transaction.setAccountNumber(accountNumber);
		transaction.setAmount(amount);
		transaction.setTransactionDetails("ATM");
		transaction.setTransactionDate(transactionDate);
		currentBalance += amount;
		transaction.setCurrentBalance(currentBalance);
		transaction.setTransactionType(TransactionType.DEPOSIT);
		
		Double updatedCurrentBalance = repository.save(transaction).getCurrentBalance();
		return updatedCurrentBalance;

	}

	@Override
	public Double withdraw(Integer accountNumber, Double amount, String transactionDetails,
			LocalDateTime transactionDate, Double currentBalance, String string) {
		Transaction transaction = new Transaction();

		transaction.setAccountNumber(accountNumber);
		transaction.setAmount(amount);
		transaction.setTransactionDetails("ATM");
		transaction.setTransactionDate(transactionDate);
		currentBalance = currentBalance - amount;
		System.out.println(currentBalance);
		transaction.setCurrentBalance(currentBalance);
		transaction.setTransactionType(TransactionType.WITHDRAW);
		Double updatedCurrentBalance = repository.save(transaction).getCurrentBalance();
		return updatedCurrentBalance;

	}
}
