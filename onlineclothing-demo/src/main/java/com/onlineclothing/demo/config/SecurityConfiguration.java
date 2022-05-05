package com.onlineclothing.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;



@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		 auth.authenticationProvider(authenticationProvider());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/api/v1/brands/**",
				 "/api/v1/categories/**","/api/v1/products/**","/api/v1/page/products",
				 "/api/v1/admin/**", "/api/v1/user/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 // disable caching
        http.headers().cacheControl();
        
		 http.cors();
		 http.csrf().disable().authorizeRequests()
		.antMatchers("/api/v1/admin/**").hasAuthority("ROLE_ADMIN")
		.antMatchers("/api/v1/user/**").hasAuthority("ROLE_USER")
		.and().httpBasic()
		//.and().logout().permitAll()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 

//		 http.cors();
//			http
//			.csrf().disable()
//			.authorizeRequests()
//			.antMatchers("/api/v1/user/**").hasRole("USER")
//			.antMatchers("/api/v1/admin/**").hasRole("ADMIN")
//			.antMatchers("/api/v1/**").permitAll()
//			.and()
//			.httpBasic();
	}
	
	
	 @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService);
	        authProvider.setPasswordEncoder(passwordEncoder());
	         
	        return authProvider;
	    }
	

	 
	 @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	
}
