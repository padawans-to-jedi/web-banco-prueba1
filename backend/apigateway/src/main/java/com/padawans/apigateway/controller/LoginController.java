package com.padawans.apigateway.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.generated.api.LoginApi;
import com.example.generated.model.LoginRequest;
import com.example.generated.model.LoginResponse;
import com.padawans.apigateway.service.LoginService;

@Controller
@CrossOrigin(origins = "*", methods= {RequestMethod.POST})
public class LoginController implements LoginApi {

	@Autowired
	LoginService service;
	
	
	@Override
	public ResponseEntity<LoginResponse> loginPost(@Valid LoginRequest loginRequest) {
		return service.loginPost(loginRequest);
	}

}
