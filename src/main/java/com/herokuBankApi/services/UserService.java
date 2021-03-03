package com.herokuBankApi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuBankApi.entities.Users;
import com.herokuBankApi.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<Users> findAll() {
		return userRepository.findAll();
	}
	
	public Users findById(Long id) {
		Optional<Users> opt = userRepository.findById(id);
		return opt.get();
	}
}
