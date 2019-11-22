package com.sambhav.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
@Table(name = "requestproduct")
public class RequestProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "requestid")
	private int requestid;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "productid")
	private Product productid;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid")
	private User userid;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date",columnDefinition = "datetime")
	private Date datetime;
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestProduct)) return false;
        RequestProduct that = (RequestProduct) o;
        return Objects.equals(productid.getProductname(), that.productid.getProductname()) &&
                Objects.equals(userid.getUsername(), that.userid.getUsername()) &&
                Objects.equals(datetime, that.datetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productid.getProductname(), userid.getUsername(), datetime);
    }
	
}
