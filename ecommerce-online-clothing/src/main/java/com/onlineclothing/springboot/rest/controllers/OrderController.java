package com.onlineclothing.springboot.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineclothing.springboot.entities.Orders;
import com.onlineclothing.springboot.repositories.OrderRepository;


@RestController
@RequestMapping("/api/v1")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/status")
	public String getStatus() {
		return "Status: OK";
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<Orders>> getAllOrders(){
		
		List<Orders> allOrders = orderRepository.findAll();
		return new ResponseEntity<List<Orders>>(allOrders,HttpStatus.OK);	
	}
	
	@PostMapping("/orders")
	public ResponseEntity<Orders> saveOrder(@RequestBody Orders order){
		
		Orders savedOrder = orderRepository.save(order);
		return new ResponseEntity<Orders>(savedOrder,HttpStatus.CREATED);
	}
}
