package com.onlineclothing.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineclothing.demo.entities.Brands;

@Repository
public interface BrandRepository extends JpaRepository<Brands, Integer> {

}
