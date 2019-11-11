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

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
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
	
	

	/*public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Product> getUserBuy() {
		return UserBuy;
	}

	public void setUserBuy(List<Product> userBuy) {
		UserBuy = userBuy;
	}

	public List<Product> getUserSell() {
		return UserSell;
	}

	public void setUserSell(List<Product> userSell) {
		UserSell = userSell;
	}

	public List<Product> getUserreports() {
		return Userreports;
	}

	public void setUserreports(List<Product> userreports) {
		Userreports = userreports;
	}

	public List<Product> getUserrequests() {
		return Userrequests;
	}

	public void setUserrequests(List<Product> userrequests) {
		Userrequests = userrequests;
	}*/
	
	
	
}
