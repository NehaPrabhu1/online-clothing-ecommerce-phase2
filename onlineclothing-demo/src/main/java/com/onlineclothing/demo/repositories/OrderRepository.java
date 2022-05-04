package com.onlineclothing.demo.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineclothing.demo.entities.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{
	
	List<Orders> findByUserid(Integer userid, Sort sort);
	
	List<Orders> findByUserid(Integer userid);

}
