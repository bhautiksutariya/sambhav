package com.sambhav.model;

import java.util.Date;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class TransactionDTO {

	@NotEmpty
	private int transactionid;
	
	@NotEmpty
	private Product productid;
	
	@NotEmpty
	private User userid;
	
	@NotEmpty
	private int qty;
	
	@NotEmpty
	private Date date;
}
