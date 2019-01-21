package com.moneymoneybank.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moneymoneybank.app.entity.Account;
import com.moneymoneybank.app.entity.CurrentAccount;
import com.moneymoneybank.app.entity.SavingsAccount;
import com.moneymoneybank.app.repo.AccountRepository;

@Service
public class AccountsServiceImpl implements AccountsService {

	@Autowired
	private AccountRepository repository;

	@Override
	public List<Account> getallAccounts() {
		return  repository.findAll();	
	}


	@Override
	public Optional<Account> getAccountById(int accountNumber) {
		return repository.findById(accountNumber);
	}


	@Override
	public void updateSavingsAccount(SavingsAccount accounts) {
		repository.save(accounts);
	}


	@Override
	public void updateCurrentAccount(CurrentAccount accounts) {
		repository.save(accounts);
	}


	@Override
	public void updateBalance(Account accounts) {
		repository.save(accounts);
	}
	
	/*
	 * @Override public void createsavingsAccount(SavingsAccount savingsAccount) {
	 * repository.save(savingsAccount); }
	 */
	

}