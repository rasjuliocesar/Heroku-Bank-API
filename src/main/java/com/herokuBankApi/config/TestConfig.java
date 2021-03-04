package com.herokuBankApi.config;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.herokuBankApi.entities.Bank;
import com.herokuBankApi.entities.Person;
import com.herokuBankApi.entities.Transaction;
import com.herokuBankApi.entities.Users;
import com.herokuBankApi.repositories.BankRepository;
import com.herokuBankApi.repositories.PersonRepository;
import com.herokuBankApi.repositories.TransactionRepository;
import com.herokuBankApi.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Users u1 = new Users(1L, "username1", "password1", Instant.now(), Instant.now());
		Users u2 = new Users(2L, "username2", "password2", Instant.now(), Instant.now());
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		Bank b1 = new Bank(1L, "X", "1234", 1000.00, Instant.now(), Instant.now());
		Bank b2 = new Bank(2L, "Standard", "5678", 2000.00, Instant.now(), Instant.now());
		Bank b3 = new Bank(3L, "Premium", "1001", 3000.00, Instant.now(), Instant.now());
		Bank b4 = new Bank(4L, "Super Premium", "1002", 4000.00, Instant.now(), Instant.now());
		bankRepository.saveAll(Arrays.asList(b1, b2, b3, b4));
		
		Person p1 = new Person(1L, "Pesso Número Um", "Rua das Avenidas", "51000000", "Pernambuco", "Brazil", sdf.parse("01/01/2000"), "112233", "5581911112222", "pessoa1@email.com", "pessoa1", "abcd1234", Instant.now(), Instant.now());
		Person p2 = new Person(2L, "Pesso Número Dois", "Avenida das Ruas", "51000000", "Pernambuco", "Brazil", sdf.parse("31/12/1990"), "445566", "5581922223333", "pessoa2@email.com", "pessoa2", "efgh5678", Instant.now(), Instant.now());
		personRepository.saveAll(Arrays.asList(p1, p2));
		
		Transaction t1 = new Transaction(1L, "trans-in", Instant.now(), "success");
		Transaction t2 = new Transaction(2L, "trans-out", Instant.now(), "success");
		Transaction t3 = new Transaction(3L, "trans-in", Instant.now(), "success");
		transactionRepository.saveAll(Arrays.asList(t1, t2, t3));
	}
}
