package com.waquar.testing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.waquar.testing.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	List<User> findByEmailOrLastName(String email,String lastName);
	
	List<User> findByEmailAndLastName(String email,String lastName);
	

	 
}
