package com.onlineclothing.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineclothing.demo.entities.Categories;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Integer> {
	

}
