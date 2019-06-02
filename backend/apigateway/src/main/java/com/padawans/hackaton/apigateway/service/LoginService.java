package com.padawans.hackaton.apigateway.service;

import org.springframework.http.ResponseEntity;

import com.padawans.hackaton.generated.api.LoginApi;
import com.padawans.hackaton.generated.model.LoginRequest;
import com.padawans.hackaton.generated.model.LoginResponse;

public interface LoginService extends LoginApi {

	ResponseEntity<LoginResponse> loginPost(LoginRequest loginRequest);

}
