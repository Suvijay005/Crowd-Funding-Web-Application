package com.app.filters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.app.jwt_utils.JwtUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JWTRequestFilter extends OncePerRequestFilter{

 @Autowired
 private JwtUtils jwtutils;
 @Autowired
 private UserDetailsService userDetailsService;

@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	log.info("in once per request filter");
	
	//get authorization header and check if not null and starting with bearer
	String header=request.getHeader("Authorization");
	if(header!=null && header.startsWith("Bearer")) {
		//=> bearer token present extract and validate it
		String token=header.substring(7);
		if(jwtutils.validateJwtToken(token)) {
			
		//=> valid token extract username from it
			String userName=jwtutils.getUserNameFromJwtToken(token);
			System.out.println(userName);
			if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				// load user details from UserDetailsService
				UserDetails userDetails=userDetailsService.loadUserByUsername(userName);
				//create Authentication object, wrapping user details lifted from database
				UsernamePasswordAuthenticationToken authentication=new UsernamePasswordAuthenticationToken(
						userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
				//set the details in auth object
				//authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				//Save this authentication token in the sec ctx.
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
			else
				log.info("user name null or authentication already set , username {}",userName);
			
		}
		else
			log.error("Request header DOES NOT contain a Bearer Token");
		//pass the request to the next filter in the chain
		filterChain.doFilter(request, response);
		
	}
	
}
	
	
	
}
