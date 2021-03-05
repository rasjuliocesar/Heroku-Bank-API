package com.herokuBankApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herokuBankApi.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
