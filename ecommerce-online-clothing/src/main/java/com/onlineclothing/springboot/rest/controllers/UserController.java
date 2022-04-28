package com.onlineclothing.springboot.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineclothing.springboot.entities.Users;
import com.onlineclothing.springboot.repositories.UserRepository;
import com.onlineclothing.springboot.services.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	private UserService userService;
    public UserController(@Autowired UserService service){
		this.userService= service;
		}
    @GetMapping("/users")
	public ResponseEntity<List<Users>> getAllUsers(){
		List<Users>users= userService.getAllUsers();
		return new ResponseEntity<List<Users>>(users,HttpStatus.OK);
		
	}
  
    @PostMapping("/users")
    public ResponseEntity<Users> save(@RequestBody Users user) {
    	Users save =userService.save(user);
    	return new ResponseEntity<Users>(save, HttpStatus.CREATED);
		
	}
    
    @GetMapping("/users/count")
    public long getCount() {
    	return userService.getUsersCount();
    }
	
    @GetMapping("/users/{id}")
	public ResponseEntity<Users> getUserById(@PathVariable("id") Integer id){
		
		Users user = userService.getUsersByUserId(id);
		if(user != null) {
			return new ResponseEntity<Users>(user,HttpStatus.OK);
		}
		return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);	
	}
	


}
