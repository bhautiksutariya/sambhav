package com.sambhav.model;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class CategoryDTO {
	
	@NotEmpty
	private String categoryname;
	
}
