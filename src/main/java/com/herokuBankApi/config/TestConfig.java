package com.herokuBankApi.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.herokuBankApi.entities.Users;
import com.herokuBankApi.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
		@Override
	public void run(String... args) throws Exception {
		
		Users u1 = new Users(1L, "username1", "password1", Instant.now(), Instant.now());
		Users u2 = new Users(2L, "username2", "password2", Instant.now(), Instant.now());
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
}
