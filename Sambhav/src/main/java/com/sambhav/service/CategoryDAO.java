package com.sambhav.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sambhav.repository.CategoryRepository;

@Service
public class CategoryDAO {
	
	@Autowired
	private CategoryRepository categoryRepository;
}
