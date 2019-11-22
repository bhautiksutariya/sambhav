package com.sambhav.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sambhav.model.Category;
import com.sambhav.model.CategoryDTO;
import com.sambhav.model.RequestProduct;
import com.sambhav.model.RequestProductDTO;
import com.sambhav.security.JwtTokenProvider;
import com.sambhav.service.CategoryDAO;
import com.sambhav.service.ProductDAO;
import com.sambhav.service.RequestProductDAO;

@RestController
@RequestMapping("/rest")
public class RequestReportController {
	
	@Autowired
	private ProductDAO productDao;
	
	@Autowired
	private CategoryDAO categoryDao;
	
	@Autowired
	private RequestProductDAO requestProductDao;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@PostMapping("/addreq")
	private String addRequest(@RequestBody CategoryDTO category)
	{
		System.out.println(category.getCategoryname());
		categoryDao.addCategory(category);
		return "Category Successfully Added";
	}
	
	@PostMapping("/requestProduct")
	private String requestProduct(@RequestBody RequestProductDTO product)
	{
		System.out.println("product "+product.getProductid());
		requestProductDao.requestProduct(product);
		return "Product Successfully Requested";
	}
	
	@GetMapping("/requestProduct")
	private List<RequestProduct> getreportedProduct()
	{
		return requestProductDao.getRequestProduct();
	}
	
	@GetMapping("/reportProduct/{id}")
	private List<RequestProduct> getreportedProduct(@PathVariable int id)
	{
		return requestProductDao.getRequestProduct(id);
	}
	
	@PostMapping("/reportProduct")
	private String reportProduct(@RequestBody RequestProductDTO product)
	{
		System.out.println("product "+product.getProductid());
		requestProductDao.requestProduct(product);
		return "Product Successfully Requested";
	}
	
	@GetMapping("/reportProduct")
	private List<RequestProduct> getrequestedProduct()
	{
		return requestProductDao.getRequestProduct();
	}
}
