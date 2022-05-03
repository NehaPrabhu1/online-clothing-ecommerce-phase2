package com.onlineclothing.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineclothing.demo.entities.Brands;
import com.onlineclothing.demo.entities.Products;
import com.onlineclothing.demo.repositories.BrandRepository;

@Service
public class BrandService {
	
	@Autowired
	private BrandRepository brandRepository;
	
	public List<Brands> findAllBrands(){
		return brandRepository.findAll();
	}
	
	public List<Products> findProductsByBrand(Integer brandid){
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
