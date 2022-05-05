package com.onlineclothing.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineclothing.demo.repositories.OrderlineRepository;

@Service
public class OrderlineService {
	
	@Autowired
	private OrderlineRepository orderlineRepository;
	
	public long getOrderlineCount() {
    	return orderlineRepository.count();
    }

}
