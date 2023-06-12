package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.User;
import com.app.service.UserService;

@RestController
@CrossOrigin(origins = "https://localhost:3000")
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/profile")
	public User showUser(Authentication auth) {
		System.out.println("Auth: "+auth.getPrincipal());
		return userService.getUserByEmail((String)auth.getPrincipal());
	}
	
	
	
	@GetMapping("/profile/{id}")
	public User showUserById(Long id) {
		return userService.getUserById(id);
	}

}
