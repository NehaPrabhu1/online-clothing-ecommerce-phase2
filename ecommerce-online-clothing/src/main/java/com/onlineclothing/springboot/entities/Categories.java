package com.onlineclothing.springboot.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "categories", schema="public")
public class Categories {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryid;
	
	private String categoryName;
	private String categoryGender;
	private String categoryType;

	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String category_name) {
		this.categoryName = category_name;
	}

	public String getCategoryGender() {
		return categoryGender;
	}

	public void setCategoryGender(String category_gender) {
		this.categoryGender = category_gender;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String category_type) {
		this.categoryType = category_type;
	}
}
