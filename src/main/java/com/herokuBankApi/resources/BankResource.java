package com.herokuBankApi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuBankApi.entities.Bank;
import com.herokuBankApi.services.BankService;

@RestController
@RequestMapping(value = "/bank")
public class BankResource {

	@Autowired
	private BankService bankService;
	
	@GetMapping
	public ResponseEntity<List<Bank>> findAll() {
		List<Bank> bank = bankService.findAll();
		return ResponseEntity.ok().body(bank);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Bank> findById(@PathVariable Long id) {
		Bank bank = bankService.findById(id);
		return ResponseEntity.ok().body(bank);
	}
}
