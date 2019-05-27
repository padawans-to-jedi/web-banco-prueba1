package com.liberbank.login_registry.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.generated.model.LoginRequest;
import com.example.generated.model.LoginResponse;
import com.liberbank.login_registry.dao.UserDAO;
import com.liberbank.login_registry.exceptions.UserRepositoryException;
import com.liberbank.login_registry.repository.UserRpository;
import com.liberbank.login_registry.security.jwt.JwtProvider;
import com.liberbank.login_registry.service.LoginService;
import com.liberbank.login_registry.utils.DataUtils;



@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
    AuthenticationManager authenticationManager;
	
	@Autowired
    JwtProvider jwtProvider;
	
	@Autowired
    UserRpository userRepository;
	
	@Override
	public ResponseEntity<LoginResponse> loginPost(LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUserName(),
                        loginRequest.getPassword()
                )
        );
		
		 SecurityContextHolder.getContext().setAuthentication(authentication);
		 
		String jwt = jwtProvider.generateJwtToken(authentication);
		
		Optional<UserDAO> user;
		try {
		 user = userRepository.findByUserName(loginRequest.getUserName());
		} catch (Exception e) {
			throw new UserRepositoryException("El ususario no ha podido recuperarse. Debido a : "+e.getMessage());
		}
	    
	    return new ResponseEntity<LoginResponse>(DataUtils.userDAOToLoginResponse(user.get(), jwt), HttpStatus.OK);
	}

}
