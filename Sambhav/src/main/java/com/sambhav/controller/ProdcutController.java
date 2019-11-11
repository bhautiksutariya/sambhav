package com.sambhav.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sambhav.model.Category;
import com.sambhav.model.CategoryDTO;
import com.sambhav.model.Product;
import com.sambhav.model.ProductDTO;
import com.sambhav.security.CurrentUser;
import com.sambhav.security.UserPrincipal;
import com.sambhav.service.CategoryDAO;
import com.sambhav.service.ProductDAO;

@RestController
@RequestMapping("/rest")
public class ProdcutController {
	
	final static String fileDirectory = System.getProperty("user.dir")+"/upload";
	
	@Autowired
	private ProductDAO productDao;
	
	@Autowired
	private CategoryDAO categoryDao;
	
	
	@PostMapping("/addCategory")
	private String addCategory(CategoryDTO category)
	{
		categoryDao.addCategory(category);
		return "Category Successfully Added";
	}
	
	@GetMapping("/getCategory")
	private List<Category> getCategory()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserPrincipal userPrincipal = (UserPrincipal) auth.getPrincipal();
		System.out.print(userPrincipal.getEmail()+":"+userPrincipal.getId());
		return categoryDao.getCategory();
	}
	
	@GetMapping("/getCategory/{id}")
	private Category getCategory(@PathVariable int id)
	{
		return categoryDao.getCategory(id);
	}
	
	@PostMapping(value = "/addProduct",consumes = { "multipart/form-data" })
	private String addProduct(String productDTO, @RequestParam("files") MultipartFile []files) throws IOException
	{
		ProductDTO product=new ObjectMapper().readValue(productDTO, ProductDTO.class);
		StringBuilder images=new StringBuilder();
		for(MultipartFile file:files)
		{
			Path filename=Paths.get(fileDirectory,file.getOriginalFilename());
			//Files.write(filename, file.getBytes());
			images.append(file.getOriginalFilename()+";");
		}
		if(images.length()>0)
		{
			images.replace(images.length()-1, images.length(), "");
		}
		productDao.addProduct(product,images);
		return "Product Successfully Added";
	}
	
	@GetMapping("/getProduct")
	@ResponseBody
	private List<Product> getProduct()
	{
		return productDao.getProduct();
	}
	
	@GetMapping("/getProduct/{id}")
	private Product getProduct(@PathVariable int id)
	{
		return productDao.getProduct(id);
	}

}
