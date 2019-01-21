package com.moneymoneybank.app.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.moneymoneybank.app.entity.Transaction;
import com.moneymoneybank.app.service.TransactionService;



@RestController
@RequestMapping("/transactions")
public class TransactionResource {
	
	@Autowired
	private RestTemplate restTemplate;

	
	@Autowired
	private TransactionService service;
	
	@PostMapping
	public ResponseEntity<Transaction> deposit(@RequestBody Transaction transaction) {
		ResponseEntity<Double> entity=restTemplate.getForEntity("http://localhost:9090/accounts/" + transaction.getAccountNumber() + "/balance",
				Double.class);
		Double currentBalance = entity.getBody();
		Double updateBalance = service.deposit(transaction.getAccountNumber(),transaction.getTransactionDetails(), currentBalance,transaction.getAmount());
		restTemplate.put("http://localhost:9090/accounts/"+transaction.getAccountNumber()+"?currentBalance="+updateBalance, null);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}