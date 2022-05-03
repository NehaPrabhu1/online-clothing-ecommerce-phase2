package com.onlineclothing.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineclothing.springboot.entities.Users;
import com.onlineclothing.springboot.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Users save(Users user) {
		Users savedUser = userRepository.save(user);
		return savedUser;
	}

	public List<Users> getAllUsers() {
		List<Users> users = userRepository.findAll();
		return users;

	}

	public Users getUsersByUserId(Integer userId) {
		Users user = userRepository.findByUserid(userId);
		return user;
	}

	public long getUsersCount() {
		return userRepository.count();
	}
	
	//getUserByEmail - service + controller

}
