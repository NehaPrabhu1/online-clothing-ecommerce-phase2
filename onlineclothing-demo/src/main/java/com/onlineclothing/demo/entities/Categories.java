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
public class Categories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryid;

	@Column(name = "category_gender")
	private String categoryGender;

	@Column(name = "category_type")
	private String categoryType;

	@Column(name = "category_name")
	private String categoryName;


	@OneToMany(fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "categoryid")
	private List<Products> products = new ArrayList<Products>();

	// this does not affect the json object
	@Override
	public String toString() {
		return "Categories [categoryid=" + categoryid + ", categoryGender=" + categoryGender + ", categoryType="
				+ categoryType + ", categoryName=" + categoryName + "]";
	}
}
