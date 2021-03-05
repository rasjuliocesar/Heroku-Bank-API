package com.herokuBankApi.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuBankApi.entities.Person;
import com.herokuBankApi.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
	public Person findById(Long id) {
		Optional<Person> person = personRepository.findById(id);
		return person.get();
	}
	
	public Person insert(Person person) {
		person.setCreatedAt(Instant.now());
		person.setUpdatedAt(Instant.now());
		return personRepository.save(person);
	}
	
	public void delete(Long id) {
		personRepository.deleteById(id);
	}
	
	public Person update(Long id, Person person) {
		Person obj = personRepository.getOne(id);
		updateData(obj, person);
		return personRepository.save(obj);
	}

	private void updateData(Person obj, Person person) {
		obj.setUpdatedAt(Instant.now());
		obj.setFullName(person.getFullName());
		obj.setAddress(person.getAddress());
		obj.setZipCode(person.getZipCode());
		obj.setState(person.getState());
		obj.setCountry(person.getCountry());
		obj.setBirthDate(person.getBirthDate());
		obj.setDocument(person.getDocument());
		obj.setPhone(person.getPhone());
		obj.setEmail(person.getEmail());
	}
}
