package com.onlineclothing.springboot.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlineclothing.springboot.entities.Products;
import com.onlineclothing.springboot.services.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

	private ProductService productService;

	public ProductController(@Autowired ProductService service) {
		this.productService = service;
	}

	// this url will read data from query parameters
	// query parameters are appended at the end of URL after ?
	// http://localhost:8080/page/products?pgnum=0&size=2
	@GetMapping(value = "/page/products", produces = "application/json")
	public List<Products> getProductsOnPage(@RequestParam("pgnum") int pageNumber, @RequestParam("size") int size) {
		List<Products> products = this.productService.getProductsBasedOnPage(pageNumber, size);
		return products;
	}

	@RequestMapping(path = "/products", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Products>> getAllProducts() {
		List<Products> products = productService.getAllProducts();
		return new ResponseEntity<List<Products>>(products, HttpStatus.OK);
	}

	@RequestMapping(path = "/products/search", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Products>> searchProducts(@RequestParam("q") String query) {
		List<Products> products = productService.searchProducts(query);
		return new ResponseEntity<List<Products>>(products, HttpStatus.OK);
	}

	@RequestMapping(path = "/products/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Products> getProductById(@PathVariable("id") int productid) {
		Products product = productService.getProductById(productid);
		if (product != null) {
			return new ResponseEntity<Products>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<Products>(product, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(path = "products/gender/{gender}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Products>> getProductsByGender(@PathVariable("gender") String gender) {
		List<Products> products = productService.getProductsByGender(gender);
		if (products != null) {
			return new ResponseEntity<List<Products>>(products, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Products>>(products, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
  
	@PostMapping("/products")
	public ResponseEntity<Products> save(@RequestBody Products product) {
		Products save = productService.save(product);
		return new ResponseEntity<Products>(save, HttpStatus.CREATED);
	}
}
