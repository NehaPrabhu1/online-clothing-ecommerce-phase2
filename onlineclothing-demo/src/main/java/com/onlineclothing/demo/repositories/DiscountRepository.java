package com.onlineclothing.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineclothing.demo.entities.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer>{
	
	List<Discount> findByCategoryid(Integer categoryid);
	
	Discount findTop1ByCategoryidAndStatusOrderByDiscountPercentDesc(Integer categoryid, String status);
//category -> Discount
}
