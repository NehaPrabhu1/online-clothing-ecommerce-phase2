package com.onlineclothing.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineclothing.springboot.entities.Orderline;


@Repository
public interface OrderlineRepository extends JpaRepository<Orderline, Integer>{

}
