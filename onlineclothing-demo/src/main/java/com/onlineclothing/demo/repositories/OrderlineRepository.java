package com.onlineclothing.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineclothing.demo.entities.Orderline;

@Repository
public interface OrderlineRepository extends JpaRepository<Orderline, Integer>{

}
