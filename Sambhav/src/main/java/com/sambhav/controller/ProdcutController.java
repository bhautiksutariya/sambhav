package com.sambhav.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sambhav.model.LoginRequest;
import com.sambhav.model.User;
import com.sambhav.repository.UserRepository;
import com.sambhav.security.JwtTokenProvider;
import com.sambhav.service.JwtAuthenticationResponse;
import com.sambhav.service.ProductDAO;

@RestController
@RequestMapping("/rest")
public class ProdcutController {
	
	@Autowired
	private ProductDAO productDao;
	
	@PostMapping("/addproduct")
	private String addProduct()
	{
		return "Test";
	}

}
