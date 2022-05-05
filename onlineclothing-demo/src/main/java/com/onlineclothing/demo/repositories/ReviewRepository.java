package com.onlineclothing.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineclothing.demo.entities.Reviews;

@Repository
public interface ReviewRepository extends JpaRepository<Reviews, Integer> {
	

}
