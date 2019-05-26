package com.padawans.apigateway.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.generated.api.RegistryApi;
import com.example.generated.model.MessageResponse;
import com.example.generated.model.UserData;

@Controller
@CrossOrigin(origins = "*", methods= {RequestMethod.POST})
public class RegistryController implements RegistryApi {

	@Override
	public ResponseEntity<MessageResponse> registryPost(@Valid UserData userdata) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
