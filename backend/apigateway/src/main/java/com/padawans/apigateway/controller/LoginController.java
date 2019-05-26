package com.padawans.apigateway.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.generated.api.LoginApi;
import com.example.generated.model.LoginRequest;
import com.example.generated.model.LoginResponse;

@Controller
@CrossOrigin(origins = "*", methods= {RequestMethod.POST})
public class LoginController implements LoginApi {

	@Override
	public ResponseEntity<LoginResponse> loginPost(@Valid LoginRequest loginRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
