package com.sambhav.model;

import java.util.Date;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class RequestProductDTO {

	@NotEmpty
	private int requestid;
	
	@NotEmpty
	private Product productid;
	
	@NotEmpty
	private User userid;
	
	@NotEmpty
	private Date datetime;
}
