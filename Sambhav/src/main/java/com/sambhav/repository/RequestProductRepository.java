package com.sambhav.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sambhav.model.Product;
import com.sambhav.model.RequestProduct;

@Repository
public interface RequestProductRepository extends JpaRepository<RequestProduct, Integer> {

	List<RequestProduct> findByProductid(Product product);
}
