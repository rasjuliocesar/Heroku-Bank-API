package com.herokuBankApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herokuBankApi.entities.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {

}
