package com.onlineclothing.demo.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.onlineclothing.demo.entities.Users;

public class AppUserDetails implements UserDetails{
	
	private String username;
	private String password;
	private String role;
	
	public AppUserDetails() {

	}
	
	public AppUserDetails(Users user) {
		this.username = user.getEmail();
		this.password = user.getLogindetail().getPassword();
		this.role = user.getRole();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.role.equalsIgnoreCase("user")) {
			return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
		}
		else if(this.role.equalsIgnoreCase("admin")) {
			return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		return null;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
	

}
