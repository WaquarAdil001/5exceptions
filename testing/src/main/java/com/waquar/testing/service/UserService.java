package com.waquar.testing.service;

import com.waquar.testing.model.User;

public interface UserService {
	
	public java.util.List<User> getUsers(String email,String lastName);

}
