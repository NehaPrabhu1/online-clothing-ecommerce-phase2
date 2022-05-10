package com.onlineclothing.demo.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineclothing.demo.entities.Reviews;
import com.onlineclothing.demo.repositories.ReviewRepository;
import com.onlineclothing.demo.services.OrderService;
import com.onlineclothing.demo.services.ReviewService;

@RestController
@RequestMapping("/api/v1")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("/products/orders/review")
	public ResponseEntity<List<Reviews>> getAllProducts(){
		List<Reviews> reviews = reviewService.findAllReviews();
		if(!reviews.isEmpty())
			return new ResponseEntity<List<Reviews>>(reviews,HttpStatus.OK);
		return new ResponseEntity<List<Reviews>>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/user/products/orders/review")
	public ResponseEntity<Reviews> saveReview(@RequestBody Reviews review){
		Reviews newReview = reviewService.insertNewReview(review);
		return new ResponseEntity<Reviews>(newReview,HttpStatus.CREATED);
	}
}
