package com.moneymoneybank.app.service;

import java.util.List;
import java.util.Optional;

import com.moneymoneybank.app.entity.Account;
import com.moneymoneybank.app.entity.CurrentAccount;
import com.moneymoneybank.app.entity.SavingsAccount;

public interface AccountsService {

	List<Account> getallAccounts();

	Optional<Account> getAccountById(int accountNumber);

	void updateSavingsAccount(SavingsAccount accounts);

	void updateCurrentAccount(CurrentAccount accounts);

	void updateBalance(Account accounts);

}
