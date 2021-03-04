package com.herokuBankApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herokuBankApi.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
