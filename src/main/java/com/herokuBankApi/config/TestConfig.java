package com.herokuBankApi.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.herokuBankApi.entities.Bank;
import com.herokuBankApi.entities.Users;
import com.herokuBankApi.repositories.BankRepository;
import com.herokuBankApi.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BankRepository bankRepository;
	
		@Override
	public void run(String... args) throws Exception {
		
		Users u1 = new Users(1L, "username1", "password1", Instant.now(), Instant.now());
		Users u2 = new Users(2L, "username2", "password2", Instant.now(), Instant.now());
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		Bank b1 = new Bank(1L, "X", "1234", 1000.00, Instant.now(), Instant.now());
		Bank b2 = new Bank(2L, "Standard", "5678", 2000.00, Instant.now(), Instant.now());
		Bank b3 = new Bank(3L, "Premium", "1001", 3000.00, Instant.now(), Instant.now());
		Bank b4 = new Bank(4L, "Super Premium", "1002", 4000.00, Instant.now(), Instant.now());
		
		bankRepository.saveAll(Arrays.asList(b1, b2, b3, b4));
	}
}
