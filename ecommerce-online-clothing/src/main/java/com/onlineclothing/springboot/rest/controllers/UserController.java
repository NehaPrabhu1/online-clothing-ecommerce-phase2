package com.onlineclothing.springboot.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineclothing.springboot.entities.Users;
import com.onlineclothing.springboot.repositories.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public ResponseEntity<List<Users>> getAllUsers(){
		
		List<Users> allUsers = userRepository.findAll();
		return new ResponseEntity<List<Users>>(allUsers,HttpStatus.OK);	
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<Users> getUserById(@PathVariable("id") Integer id){
		
		Users user = userRepository.findByUserid(id);
		if(user != null) {
			return new ResponseEntity<Users>(user,HttpStatus.OK);
		}
		return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);	
	}

}
