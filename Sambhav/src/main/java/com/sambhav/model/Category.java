package com.sambhav.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoryid")
	private int categoryid;
	
	@Column(name = "categoryname",nullable = false)
	private String categoryname;
	
	@Column(name = "isactive",nullable = false,columnDefinition = "boolean default true")
	private boolean status;
	
	@OneToMany(mappedBy = "categoryid",fetch = FetchType.LAZY)
	private List<Product> products;
	
	
}
