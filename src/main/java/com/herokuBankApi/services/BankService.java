package com.herokuBankApi.services;

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
}
