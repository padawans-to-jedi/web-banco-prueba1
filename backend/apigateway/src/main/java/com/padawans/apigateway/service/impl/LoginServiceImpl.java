package com.padawans.apigateway.service.impl;

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
import com.padawans.apigateway.dao.UserDAO;
import com.padawans.apigateway.exceptions.UserRepositoryException;
import com.padawans.apigateway.repository.UserRpository;
import com.padawans.apigateway.security.jwt.JwtProvider;
import com.padawans.apigateway.service.LoginService;
import com.padawans.apigateway.utils.DataUtils;



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
