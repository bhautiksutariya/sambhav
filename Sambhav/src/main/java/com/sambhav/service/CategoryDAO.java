package com.sambhav.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sambhav.model.Category;
import com.sambhav.model.CategoryDTO;
import com.sambhav.repository.CategoryRepository;

@Service
public class CategoryDAO {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category addCategory(CategoryDTO category)
	{
		Category c=new Category();
		c.setCategoryname(category.getCategoryname());
		c.setStatus(true);
		return categoryRepository.save(c);
	}
	
	public List<Category> getCategory()
	{
		return categoryRepository.findAll();
	}
	
	public Category getCategory(int id)
	{
		return categoryRepository.findByCategoryid(id);
	}
	
}
