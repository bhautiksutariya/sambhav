package com.sambhav.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sambhav.model.SignUpRequest;
import com.sambhav.model.User;
import com.sambhav.repository.UserRepository;

@Service
public class UserDAO {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User addUser(SignUpRequest signUpRequest)
	{
		User user = new User();
        
        user.setEmail(signUpRequest.getEmail());
        
        user.setContactno(signUpRequest.getContactno());
        
        user.setUsername(signUpRequest.getName());

        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        user.setRole("user");
        
        user.setStatus(true);

        return userRepository.save(user);
	}
	
	public User getUserByEmail(String email)
	{
		return userRepository.findByEmail(email);
	}
	
	public boolean existsByEmail(String email)
	{
		return userRepository.existsByEmail(email);
	}
	
	
	
}
