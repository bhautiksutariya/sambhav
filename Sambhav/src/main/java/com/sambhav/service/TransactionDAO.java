package com.sambhav.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sambhav.repository.TransactionRepository;

@Service
public class TransactionDAO {

	@Autowired
	private TransactionRepository transactionRepository;
	
}
