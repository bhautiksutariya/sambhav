package com.sambhav.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productid")
	private int productid;
	
	@Column(name = "productname",nullable = false)
	private String productname;
	
	@Column(name = "description",nullable = false,length = 5000)
	private String description;
	
	@Column(name = "qty",nullable = false)
	private int qty;
	
	@Column(name = "price",nullable = false)
	private double price;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoryid",nullable = false)
	private Category categoryid;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "userid",nullable = false)
	private User userid;
	
	@Column(name = "images")
	private String images;
	
	@Column(name = "isactive",nullable = false,columnDefinition = "boolean default true")
	private boolean status;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "productid",fetch = FetchType.LAZY,targetEntity = Transaction.class)
	private List<Product> Productbuyers;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "productid",fetch = FetchType.LAZY,targetEntity = ReportProduct.class)
	private List<Product> Productreports;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "productid",fetch = FetchType.LAZY,targetEntity = RequestProduct.class)
	private List<Product> Productrequests;
	
}
