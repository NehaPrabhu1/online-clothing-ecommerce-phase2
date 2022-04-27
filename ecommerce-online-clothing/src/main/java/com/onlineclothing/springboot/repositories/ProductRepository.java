package com.onlineclothing.springboot.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.onlineclothing.springboot.entities.Products;

// @Repository is optional for Spring Data JPA Repositories
@Repository
@Component
public interface ProductRepository extends JpaRepository<Products, Integer> {

	List<Products> findByCategoryid(Integer categoryid);
	
	// custom queries
	//ILIKE makes the query case-insensitive
	@Query(value = "SELECT * FROM products WHERE product_name ILIKE %:productName%", nativeQuery=true)
	public List<Products> findAllByName(@Param("productName") String productName);
	
	@Query(value = "SELECT * from products INNER JOIN categories USING(categoryid) WHERE categories.category_gender = :gender", nativeQuery = true)
	public List<Products> findAllByGender(@Param("gender") String gender);
	
	//public List<Products> findByProductName(String productname, Sort sort);
	
	//@Query("SELECT * FROM reviews WHERE productid = ?1")
	//TODO
		
	
}
