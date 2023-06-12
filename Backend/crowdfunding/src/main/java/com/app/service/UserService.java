package com.app.service;

import com.app.entities.User;

public interface UserService {

	User addNewUser(User user);
	
	User getUserById(Long id);
	
	User getUserByEmail(String email);
	
}
