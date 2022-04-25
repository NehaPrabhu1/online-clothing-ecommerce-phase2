package com.onlineclothing.springboot.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Categories {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long categoryid;
	
	private String categoryname;
	private String categorytype;
	
	@OneToMany(targetEntity = Products.class, mappedBy="categoryid")
	@JoinColumn(name="categoryid")
	private List<Products> products;

}
