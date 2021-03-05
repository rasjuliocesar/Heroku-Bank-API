package com.herokuBankApi.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuBankApi.entities.Bank;
import com.herokuBankApi.repositories.BankRepository;

@Service
public class BankService {

	@Autowired
	private BankRepository bankRepository;
	
	public List<Bank> findAll() {
		return bankRepository.findAll();
	}
	
	public Bank findById(Long id) {
		Optional<Bank> bank = bankRepository.findById(id);
		return bank.get();
	}
	
	public Bank insert(Bank bank) {
		bank.setCreatedAt(Instant.now());
		bank.setUpdateAt(Instant.now());
		bank.setAccountValue(0.0);
		return bankRepository.save(bank);
	}
	
	public void delete(Long id) {
		bankRepository.deleteById(id);
	}
	
	public Bank update(Long id, Bank bank) {
		Bank obj = bankRepository.getOne(id);
		updateData(obj, bank);
		return bankRepository.save(obj);
	}

	private void updateData(Bank obj, Bank bank) {
		obj.setAccountValue(bank.getAccountValue());
		obj.setUpdateAt(Instant.now());
		
	}
}
