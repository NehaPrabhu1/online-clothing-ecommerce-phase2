package com.onlineclothing.demo.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineclothing.demo.entities.Users;

@SpringBootTest
class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void addUserTest() {
		Users user1 = new Users();
		user1.setEmail("john@abc.com");
		user1.setFirstName("John");
		user1.setLastName("Parker");
		user1.setRole("user");
		userRepository.save(user1);
	}
	
	
	

}
