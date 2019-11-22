package com.sambhav.model;

import java.util.Date;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class RequestProductDTO {

	@NotEmpty
	private int productid;
	
}
