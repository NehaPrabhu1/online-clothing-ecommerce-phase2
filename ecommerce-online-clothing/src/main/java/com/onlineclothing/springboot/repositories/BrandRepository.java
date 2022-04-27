package com.onlineclothing.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineclothing.springboot.entities.Brands;



@Repository
public interface BrandRepository extends JpaRepository<Brands, Integer> {

}
