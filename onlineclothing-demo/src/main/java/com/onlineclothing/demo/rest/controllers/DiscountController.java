package com.onlineclothing.demo.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineclothing.demo.entities.Discount;
import com.onlineclothing.demo.services.DiscountService;

@RestController
@RequestMapping("/api/v1")
public class DiscountController {
	
	@Autowired
	private DiscountService discountService;
	
	@GetMapping("/admin/discount")
	public ResponseEntity<List<Discount>> getAllDiscounts(){
		List<Discount> discounts = discountService.updateDiscount();
		return new ResponseEntity<List<Discount>>(discounts,HttpStatus.OK);
	}
	
	@PostMapping("/admin/discount")
	public ResponseEntity<Discount> createDiscount(@RequestBody Discount discount){
		Discount newDiscount = discountService.newDiscount(discount);
		if(newDiscount == null) {
			return new ResponseEntity<Discount>(newDiscount,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Discount>(newDiscount,HttpStatus.CREATED);
	}
	
	@GetMapping("/discount/categoryid/{id}")
	public ResponseEntity<Discount> getLiveDiscountByCategory(@PathVariable(name = "id")Integer categoryid){
		Discount liveDiscountByCategory = discountService.getLiveDiscountByCategory(categoryid);
		if(liveDiscountByCategory == null) {
			return new ResponseEntity<Discount>(liveDiscountByCategory,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Discount>(liveDiscountByCategory,HttpStatus.CREATED);
	}
	
	@GetMapping("/admin/discount/count")
    public long getCount() {
    	return discountService.getDiscountCount();
    }
 
}
