package com.onlineclothing.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineclothing.demo.entities.Reviews;
import com.onlineclothing.demo.repositories.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	public List<Reviews> findAllReviews(){
		return reviewRepository.findAll();
	}
	
	public Reviews insertNewReview(Reviews review) {
		Reviews savedReview = reviewRepository.save(review);
		return savedReview;
	}

}
