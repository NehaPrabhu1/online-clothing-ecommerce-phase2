package com.onlineclothing.demo.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineclothing.demo.entities.Users;

@SpringBootTest
class UserServiceTest {
	
	@Autowired
	UserService service;

	@Test
	public void testSaveUser() {
		Users user = new Users();
		user.setEmail("john@gmail.com");
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setRole("user");
	    Users savedUser = service.save(user);
		
		String actualName = savedUser.getFirstName();
		String expectedName = "John";
		System.out.println("=>Create tested: "+actualName+" "+ expectedName);
		assertEquals(expectedName,actualName);
	}
	
	@Test 
	void testGetAllUsers() {
		List<Users> users = service.getAllUsers();
		System.out.println(users);
		assertTrue(users.size()> 0);
	}
	
	@Test 
	void testGetUsersByUserId() {
		Integer id = 5;
		Users user = service.getUsersByUserId(id);
		String expectedName = "John";
		String actualName = user.getFirstName();
		assertEquals(expectedName, actualName);
	}
	
	@Test 
	void testGetUsersCount() {
		long count = service.getUsersCount();
		System.out.println(count);
	}
	
	@Test 
	void testgetUserByEmail() {
		String email = "john@gmail.com";
		Users user = service.getUserByEmail(email);
		System.out.println(user);
		
	}

}
