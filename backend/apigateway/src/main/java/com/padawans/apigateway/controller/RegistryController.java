package com.padawans.apigateway.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.generated.api.RegistryApi;
import com.example.generated.model.MessageResponse;
import com.example.generated.model.UserData;
import com.padawans.apigateway.service.RegistryService;

@Controller
@CrossOrigin(origins = "*", methods= {RequestMethod.POST})
public class RegistryController implements RegistryApi {

	
	@Autowired
	RegistryService service;
	
	@Override
	public ResponseEntity<MessageResponse> registryPost(@Valid UserData userdata) {
		return service.registryPost(userdata);
	}

	
	

}
