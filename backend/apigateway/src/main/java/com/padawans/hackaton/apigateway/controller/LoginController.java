package com.padawans.hackaton.apigateway.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.padawans.hackaton.apigateway.service.LoginService;
import com.padawans.hackaton.generated.api.LoginApi;
import com.padawans.hackaton.generated.model.LoginRequest;
import com.padawans.hackaton.generated.model.LoginResponse;

@Controller
@CrossOrigin(origins = "*", methods = { RequestMethod.POST })
public class LoginController implements LoginApi {

	@Autowired
	LoginService service;

	@Override
	public ResponseEntity<LoginResponse> loginPost(@Valid LoginRequest loginRequest) {
		return service.loginPost(loginRequest);
	}

}
