package com.onlineclothing.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onlineclothing.demo.entities.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
	
	
	List<Products> findAll();
	
	List<Products> findByCategoryid(Integer categoryid);
	
	List<Products> findByColor(String color);
	
	// custom queries
	//ILIKE makes the query case-insensitive
	@Query(value = "SELECT * FROM products WHERE product_name ILIKE %:productName%", nativeQuery=true)
	public List<Products> findAllByName(@Param("productName") String productName);
	
	@Query(value = "SELECT * FROM products INNER JOIN categories USING(categoryid) WHERE categories.category_gender = :gender", nativeQuery = true)
	public List<Products> findAllByGender(@Param("gender") String gender);
	
	@Query(value = "SELECT * FROM products WHERE categoryid = :id", nativeQuery = true)
	public List<Products> findByCategoryid(@Param("id") int categoryid);
	
}
