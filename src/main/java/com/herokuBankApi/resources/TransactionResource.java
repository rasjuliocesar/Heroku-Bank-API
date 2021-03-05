package com.herokuBankApi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Transaction> insert(@RequestBody Transaction transaction) {
		transaction = transactionService.insert(transaction);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(transaction.getId()).toUri();
		return ResponseEntity.created(uri).body(transaction);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		transactionService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Transaction> update(@PathVariable Long id, @RequestBody Transaction transaction) {
		transaction = transactionService.update(id, transaction);
		return ResponseEntity.ok().body(transaction);
	}
}
