package com.sambhav.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.sambhav.security.UserPrincipal;

public class CurrentUser {

	static Authentication getUserAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	static UserPrincipal getUserPrincipal() {
		return (UserPrincipal)getUserAuthentication().getPrincipal();
	}
	
	public static String getCurrentUserEmail()
	{
		return getUserPrincipal().getEmail();
	}
	
	public static long getCurrentUserId()
	{
		return getUserPrincipal().getId();
	}
	
	public static String getCurrentUsername()
	{
		return getUserPrincipal().getUsername();
	}
}
