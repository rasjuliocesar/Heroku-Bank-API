package com.herokuBankApi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuBankApi.entities.Person;
import com.herokuBankApi.services.PersonService;

@RestController
@RequestMapping(value = "/person")
public class PersonResource {

	@Autowired
	private PersonService personService;
	
	@GetMapping
	public ResponseEntity<List<Person>> findAll() {
		List<Person> person = personService.findAll();
		return ResponseEntity.ok().body(person);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Person> findById(@PathVariable Long id) {
		Person person = personService.findById(id);
		return ResponseEntity.ok().body(person);
	}
}
