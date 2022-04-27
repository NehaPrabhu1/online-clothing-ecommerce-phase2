package com.onlineclothing.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineclothing.springboot.entities.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	
	Users findByUserid(Integer userid);

}
