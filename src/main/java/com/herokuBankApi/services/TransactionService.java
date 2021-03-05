package com.herokuBankApi.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuBankApi.entities.Transaction;
import com.herokuBankApi.repositories.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	
	public List<Transaction> findAll() {
		return transactionRepository.findAll();
	}
	
	public Transaction findById(Long id) {
		Optional<Transaction> transaction = transactionRepository.findById(id);
		return transaction.get();
	}
	
	public Transaction insert(Transaction transaction) {
		transaction.setMoment(Instant.now());
		return transactionRepository.save(transaction);
	}
	
	public void delete(Long id) {
		transactionRepository.deleteById(id);
	}
	
	public Transaction update(Long id, Transaction transaction) {
		Transaction obj = transactionRepository.getOne(id);
		updateData(obj, transaction);
		return transactionRepository.save(obj);
	}

	private void updateData(Transaction obj, Transaction transaction) {
		obj.setType(transaction.getType());
		obj.setMoment(Instant.now());
		obj.setResponse(transaction.getResponse());
	}
}
