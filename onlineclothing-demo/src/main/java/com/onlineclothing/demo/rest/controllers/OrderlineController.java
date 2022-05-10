package com.onlineclothing.demo.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineclothing.demo.services.OrderlineService;

@RestController
@RequestMapping("/api/v1")
public class OrderlineController {
	
	@Autowired
	private OrderlineService orderlineService;
	
	 @GetMapping("/admin/orderlines/count")
	    public long getCount() {
	    	return orderlineService.getOrderlineCount();
	    }

}
