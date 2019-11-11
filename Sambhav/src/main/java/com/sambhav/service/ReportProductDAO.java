package com.sambhav.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sambhav.repository.ReportProductRepository;

@Service
public class ReportProductDAO {

	@Autowired
	private ReportProductRepository reportProductRepository;
	
}
