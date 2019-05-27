package com.liberbank.login_registry.service;

import org.springframework.http.ResponseEntity;

import com.example.generated.model.LoginRequest;
import com.example.generated.model.LoginResponse;

public interface LoginService {
	
	ResponseEntity<LoginResponse> loginPost(LoginRequest loginRequest) ;

}
