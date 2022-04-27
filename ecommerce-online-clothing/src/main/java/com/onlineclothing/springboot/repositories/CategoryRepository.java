package com.onlineclothing.springboot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineclothing.springboot.entities.Categories;


@Repository
public interface CategoryRepository extends JpaRepository<Categories, Integer> {
	

}
