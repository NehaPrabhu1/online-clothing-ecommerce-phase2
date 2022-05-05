package com.onlineclothing.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.onlineclothing.demo.repositories.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class OnlineclothingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineclothingDemoApplication.class, args);
	}

}
