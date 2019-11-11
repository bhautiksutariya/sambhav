package com.sambhav.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sambhav.repository.RequestProductRepository;

@Service
public class RequestProductDAO {

	@Autowired
	private RequestProductRepository requestProductRepository;
	
}
