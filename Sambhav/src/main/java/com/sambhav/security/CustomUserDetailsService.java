package com.sambhav.security;


import com.sambhav.model.User;
import com.sambhav.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        // Let people login with either username or email
    	User user = userRepository.findByEmail(usernameOrEmail);
    	
    	if(user==null)
    	{
    		throw new UsernameNotFoundException("User not found");
    	}

        return UserPrincipal.create(user);
    }

    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(int id) {
        User user = userRepository.findByUserid(id);;
        
        if(user==null)
    	{
    		throw new UsernameNotFoundException("User not found");
    	}

        return UserPrincipal.create(user);
    }
}
