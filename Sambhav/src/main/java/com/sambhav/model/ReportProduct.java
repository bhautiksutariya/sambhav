package com.sambhav.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
@Table(name = "reportproduct")
public class ReportProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reportid")
	private int reportid;
	
	@ManyToOne
	@JoinColumn(name = "productid")
	private Product productid;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private User userid;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date",columnDefinition = "datetime")
	private Date datetime;
	
}
