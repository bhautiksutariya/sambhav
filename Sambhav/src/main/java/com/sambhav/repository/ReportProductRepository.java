package com.sambhav.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sambhav.model.ReportProduct;

@Repository
public interface ReportProductRepository extends JpaRepository<ReportProduct, Integer> {

}
