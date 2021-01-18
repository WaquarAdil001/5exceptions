package com.waquar.testing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waquar.testing.model.User;
import com.waquar.testing.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repository;

	@Override
	public List<User> getUsers(String email, String lastName) {
		
		return repository.findByEmailOrLastName(email, lastName);
	}

	

}
