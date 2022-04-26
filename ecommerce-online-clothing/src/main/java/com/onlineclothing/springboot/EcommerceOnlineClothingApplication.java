package com.onlineclothing.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.onlineclothing.springboot.rest.controllers.ProductController;

@SpringBootApplication
public class EcommerceOnlineClothingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceOnlineClothingApplication.class, args);
	}

}
