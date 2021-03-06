package com.moneymoneybank.app.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moneymoneybank.app.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	
	public List<Transaction> findByTransactionDateBetween(LocalDateTime startDate , LocalDateTime endDate);
}
