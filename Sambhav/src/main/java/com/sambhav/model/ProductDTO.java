package com.sambhav.model;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class ProductDTO {
	
	@NotEmpty
	private String productname;
	
	@NotEmpty
	private String description;
	
	@NotEmpty
	private int qty;
	
	@NotEmpty
	private double price;
	
	@NotEmpty
	private int categoryid;
}
