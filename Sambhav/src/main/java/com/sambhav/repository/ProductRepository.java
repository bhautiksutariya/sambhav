package com.sambhav.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sambhav.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
