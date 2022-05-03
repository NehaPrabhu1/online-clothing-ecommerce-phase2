package com.onlineclothing.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.onlineclothing.demo.entities.Users;
import com.onlineclothing.demo.repositories.UserRepository;

@Service
public class AppUserDetailsService  implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		Users user = userRepository.findByEmail(userEmail);
		if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
		return new AppUserDetails(user);
	}

}
