package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.User;
import com.app.repository.UserRepository;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
@Autowired
private UserRepository userRepo;

@Override
public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	// TODO Auto-generated method stub
	User user=userRepo.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("Invalid email id"));
	return new CustomUserDetails(user);
}




}
