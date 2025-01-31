package com.sambhav.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sambhav.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	@Query(value = "select * from category where isactive=true",nativeQuery = true)
	List<Category> findAll();
	
	@Query(value = "select * from category where isactive=true and categoryid=?1",nativeQuery = true)
	Category findByCategoryid(int id);
	
}
