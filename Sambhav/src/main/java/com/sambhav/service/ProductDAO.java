package com.sambhav.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sambhav.model.Product;
import com.sambhav.model.ProductDTO;
import com.sambhav.repository.ProductRepository;

@Service
public class ProductDAO {

	@Autowired
	private ProductRepository productRepository;
	
	public Product addProduct(ProductDTO product)
	{
		Product p=new Product();
		return productRepository.save(p);
	}
	
	public List<Product> getProduct()
	{
		return productRepository.findAll();
	}
	
	public Product getProduct(int id)
	{
		return productRepository.findByProductid(id);
	}
	
}
