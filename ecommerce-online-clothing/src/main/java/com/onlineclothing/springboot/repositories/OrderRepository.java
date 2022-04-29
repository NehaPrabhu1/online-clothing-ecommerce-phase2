package com.onlineclothing.springboot.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineclothing.springboot.entities.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{
	
	Page<Orders> findByUserid(Integer userid, Pageable pageable);
	
	List<Orders> findByUserid(Integer userid);
}
