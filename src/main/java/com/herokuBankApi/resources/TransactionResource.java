package com.herokuBankApi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuBankApi.entities.Transaction;
import com.herokuBankApi.services.TransactionService;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionResource {

	@Autowired
	private TransactionService transactionService;
	
	@GetMapping
	public ResponseEntity<List<Transaction>> findAll() {
		List<Transaction> transactions = transactionService.findAll();
		return ResponseEntity.ok().body(transactions);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Transaction> findById(@PathVariable Long id) {
		Transaction transaction = transactionService.findById(id);
		return ResponseEntity.ok().body(transaction);
	}
}
