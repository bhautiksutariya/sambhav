package com.sambhav.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sambhav.model.Category;
import com.sambhav.model.Product;
import com.sambhav.model.ProductDTO;
import com.sambhav.repository.ProductRepository;

@Service
public class ProductDAO {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryDAO categoryDao;
	
	@Autowired
	private UserDAO userDao;
	
	public Product addProduct(ProductDTO product,StringBuilder images)
	{
		Product p=new Product();
		p.setDescription(product.getDescription());
		p.setImages(images.toString());
		p.setPrice(product.getPrice());
		p.setProductname(product.getProductname());
		p.setQty(product.getQty());
		p.setStatus(true);
		p.setUserid(userDao.getUserByEmail(CurrentUser.getCurrentUserEmail()));
		p.setCategoryid(categoryDao.getCategory(product.getCategoryid()));
		
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
