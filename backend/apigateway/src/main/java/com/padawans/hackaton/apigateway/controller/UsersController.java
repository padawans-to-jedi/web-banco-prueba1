package com.padawans.hackaton.apigateway.controller;

import javax.validation.constraints.Min;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.padawans.hackaton.generated.api.UsersApi;

@Controller
@CrossOrigin(origins = "*", methods = { RequestMethod.POST })
public class UsersController implements UsersApi {

	@Override
	public ResponseEntity<Void> usersUserIDProductsPost(@Min(1) Integer userID) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
