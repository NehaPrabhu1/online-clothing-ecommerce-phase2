package com.onlineclothing.demo.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineclothing.demo.entities.Brands;
import com.onlineclothing.demo.entities.Products;
import com.onlineclothing.demo.repositories.BrandRepository;
import com.onlineclothing.demo.services.BrandService;

@RestController
@RequestMapping("/api/v1")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@GetMapping("/brands")
	public ResponseEntity<List<Brands>> getAllBrands(){
		List<Brands> allBrands = brandService.findAllBrands();
		return new ResponseEntity<List<Brands>>(allBrands,HttpStatus.OK);
	}
	
	@GetMapping("/brands/{id}")
	public ResponseEntity<List<Products>> getProductsByBrand(@PathVariable("id") Integer brandid){
		List<Products> products = brandService.findProductsByBrand(brandid);
		if(products != null) {
			return new ResponseEntity<List<Products>>(products,HttpStatus.OK);
		}
		return new ResponseEntity<List<Products>>(HttpStatus.BAD_REQUEST);
	}
	
	 @GetMapping("/admin/brands/count") 
	    public long getCount() {
	    	return brandService.getBrandsCount();
	    }
	
	
}
