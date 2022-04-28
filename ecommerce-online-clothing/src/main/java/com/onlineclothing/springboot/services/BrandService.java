package com.onlineclothing.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineclothing.springboot.entities.Brands;
import com.onlineclothing.springboot.entities.Products;
import com.onlineclothing.springboot.repositories.BrandRepository;



@Service
public class BrandService {
	
	@Autowired
	private BrandRepository brandRepository;
	
	public List<Products> getProductsByBrand(Integer brandid){
		List<Products> products = null;
		Optional<Brands> optional = brandRepository.findById(brandid);
		if(optional.isPresent()) {
			Brands brand = optional.get();
			products = brand.getProducts();
		}
		return products;
	}
	
	public long getBrandsCount() {
    	return brandRepository.count();
    }

}
