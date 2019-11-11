package com.sambhav.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sambhav.repository.ProductRepository;

@Service
public class ProductDAO {

	@Autowired
	private ProductRepository productRepository;
	
}
