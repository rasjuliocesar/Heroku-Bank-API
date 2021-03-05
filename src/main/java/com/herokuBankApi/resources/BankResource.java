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
	
	@PostMapping
	public ResponseEntity<Bank> insert(@RequestBody Bank bank) {
		bank = bankService.insert(bank);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(bank.getId()).toUri();
		return ResponseEntity.created(uri).body(bank);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		bankService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Bank> update(@PathVariable Long id, @RequestBody Bank bank) {
		bank = bankService.update(id, bank);
		return ResponseEntity.ok().body(bank);
	}
}
