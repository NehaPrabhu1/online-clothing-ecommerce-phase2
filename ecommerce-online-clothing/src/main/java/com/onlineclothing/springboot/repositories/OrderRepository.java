package com.onlineclothing.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineclothing.springboot.entities.Orders;


@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{

}
