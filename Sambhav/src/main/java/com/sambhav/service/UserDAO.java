package com.sambhav.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sambhav.model.User;
import com.sambhav.repository.UserRepository;

@Service
public class UserDAO {

	@Autowired
	private UserRepository userRepository;
	
	
	
}
