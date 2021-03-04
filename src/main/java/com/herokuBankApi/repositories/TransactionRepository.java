package com.herokuBankApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herokuBankApi.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
