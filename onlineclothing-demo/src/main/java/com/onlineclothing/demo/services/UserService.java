package com.onlineclothing.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineclothing.demo.entities.Users;
import com.onlineclothing.demo.repositories.UserRepository;

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
	
	public Users getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}


}
