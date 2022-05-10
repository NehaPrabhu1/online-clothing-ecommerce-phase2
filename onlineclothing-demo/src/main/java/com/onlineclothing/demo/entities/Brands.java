package com.onlineclothing.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString
public class Brands {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer brandid;

	@Column(name = "brand_name")
	private String brandName;


	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "brandid")
	private List<Products> products = new ArrayList<Products>();

	
	@Override
	public String toString() {
		return "Brands [brandid=" + brandid + ", brandName=" + brandName + "]";
	}
}

