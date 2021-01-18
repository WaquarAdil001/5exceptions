package com.waquar.testing.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.waquar.testing.dto.ErrorResponse;
import com.waquar.testing.dto.SuccessResponse;
import com.waquar.testing.model.User;
import com.waquar.testing.repository.UserRepository;
import com.waquar.testing.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private UserRepository repository;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/users")
	public ResponseEntity<?> getUsersByEmailAndLastName(@RequestParam(name="email") String email,@RequestParam(name = "lastName") String lastName){
		logger.info("My email "+email+" my lastName is "+lastName);
		List<User> users =  service.getUsers(email, lastName);
		for (User user : users) {
			logger.info("user "+user.getFirstName());
		}
		if(users.isEmpty()||users==null) {
			 new ResponseEntity<>(users,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@GetMapping("/myusers")
	public ResponseEntity<?> getUsers(){
		List<User> users = repository.findAll();
		logger.info("My user is "+users.toString());
		for (User user : users) {
			logger.info("My user is "+user.getFirstName());

		}
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@PostMapping("/users")
	public ResponseEntity<?> addUser(@RequestBody User user){
		if(!user.equals(null)) {
			repository.save(user);
			SuccessResponse response =  new SuccessResponse(true, 200, "User Added Is Successfully", user);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}else {
			ErrorResponse response =  new ErrorResponse(false, 500, "Internal Server Error", null, null);
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
