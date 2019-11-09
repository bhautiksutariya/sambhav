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
import javax.validation.constraints.Email;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private int userid;
	
	@Column(name = "name",nullable = false,length = 255)
	private String username;
	
	@Email
	@Column(name = "email",nullable = false,length = 255,unique = true)
	private String email;
	
	@Column(name = "password",nullable = false,length = 255)
	private String password;
	
	@Column(name = "contactno",nullable = false,length = 13)
	private String contactno;
	
	@Column(name = "isactive",nullable = false,columnDefinition = "boolean default true")
	private boolean status;
	
	@Column(name = "role",nullable = false)
	private String role;
	
	@OneToMany(mappedBy = "userid",fetch = FetchType.LAZY,targetEntity = Transaction.class)
	private List<Product> UserBuy;
	
	@OneToMany(mappedBy = "userid",fetch = FetchType.LAZY,targetEntity = Product.class)
	private List<Product> UserSell;
	
	@OneToMany(mappedBy = "userid",fetch = FetchType.LAZY,targetEntity = ReportProduct.class)
	private List<Product> Userreports;
	
	@OneToMany(mappedBy = "userid",fetch = FetchType.LAZY,targetEntity = RequestProduct.class)
	private List<Product> Userrequests;
	
}
