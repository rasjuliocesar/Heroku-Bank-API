package com.herokuBankApi.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuBankApi.entities.Users;
import com.herokuBankApi.repositories.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	public List<Users> findAll() {
		return usersRepository.findAll();
	}
	
	public Users findById(Long id) {
		Optional<Users> opt = usersRepository.findById(id);
		return opt.get();
	}
	
	public Users insert(Users user) {
		user.setCreatedAt(Instant.now());
		user.setUpdatedAt(Instant.now());
		return usersRepository.save(user);
	}
	
	public void delete(Long id) {
		usersRepository.deleteById(id);
	}
	
	public Users update(Long id, Users user) {
		Users obj = usersRepository.getOne(id);
		updateData(obj, user);
		return usersRepository.save(obj);
	}

	private void updateData(Users obj, Users user) {
		obj.setUsername(user.getUsername());
		obj.setPassword(user.getPassword());
		obj.setUpdatedAt(Instant.now());
		
	}
}
