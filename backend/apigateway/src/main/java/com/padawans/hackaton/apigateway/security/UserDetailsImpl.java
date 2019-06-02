package com.padawans.hackaton.apigateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.padawans.hackaton.apigateway.dao.UserDAO;
import com.padawans.hackaton.apigateway.repository.UserRpository;

@Service
public class UserDetailsImpl implements UserDetailsService {

    @Autowired
    UserRpository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
    	
        UserDAO user = userRepository.findByUserName(username)
                	.orElseThrow(() -> 
                        new UsernameNotFoundException("User Not Found with -> username or email : " + username)
        );

        return UserPrinciple.build(user);
    }
}