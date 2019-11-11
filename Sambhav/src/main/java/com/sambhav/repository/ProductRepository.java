package com.sambhav.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sambhav.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(value = "select * from product where isactive=true", nativeQuery = true)
	List<Product> findAll();
	
	@Query(value = "select * from product where isactive=true and productid=?1", nativeQuery = true)
	Product findByProductid(int id);
	
}
