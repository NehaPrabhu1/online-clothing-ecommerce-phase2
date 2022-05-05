package com.onlineclothing.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineclothing.demo.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	
	Users findByUserid(Integer userid);
	
	Users findByEmail(String userEmail);

}
