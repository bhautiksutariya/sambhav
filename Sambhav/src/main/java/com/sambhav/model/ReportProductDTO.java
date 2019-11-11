package com.sambhav.model;

import java.util.Date;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class ReportProductDTO {

	@NotEmpty
	private int reportid;
	
	@NotEmpty
	private Product productid;
	
	@NotEmpty
	private User userid;
	
	@NotEmpty
	private Date datetime;
	
}
