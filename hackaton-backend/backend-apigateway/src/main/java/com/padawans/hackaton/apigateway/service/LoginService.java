package com.padawans.hackaton.apigateway.service;

import org.springframework.http.ResponseEntity;

import com.padawans.hackaton.generated.model.LoginRequest;
import com.padawans.hackaton.generated.model.LoginResponse;

public interface LoginService {

	ResponseEntity<LoginResponse> loginPost(LoginRequest loginRequest);

}
