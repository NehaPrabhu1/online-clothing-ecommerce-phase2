package com.onlineclothing.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "login_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginDetails {
	
	@Id
	private Integer userid;
	private String password;
	
	@OneToOne
	@JoinColumn(name = "userid")
	@JsonIgnore
	private Users user;

}
