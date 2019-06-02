package com.padawans.hackaton.apigateway.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.padawans.hackaton.apigateway.service.UserService;
import com.padawans.hackaton.generated.api.UsersApi;
import com.padawans.hackaton.generated.model.Accountrequest;
import com.padawans.hackaton.generated.model.AccountsGetResponse;
import com.padawans.hackaton.generated.model.AccountsResponse;
import com.padawans.hackaton.generated.model.MessageResponse;
import com.padawans.hackaton.generated.model.PaymentsRequest;
import com.padawans.hackaton.generated.model.UserDataUpdate;

@Controller
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT })
public class UsersController implements UsersApi {

	@Autowired
	UserService service;

	@Override
	public ResponseEntity<AccountsGetResponse> usersUserIDAccountsGet(@Min(1) Long userID) {
		return service.usersUserIDAccountsGet(userID);
	}

	@Override
	public ResponseEntity<AccountsResponse> usersUserIDAccountsPost(@Min(1) Long userID,
			@Valid Accountrequest accountRequest) {
		return service.usersUserIDAccountsPost(userID, accountRequest);
	}

	@Override
	public ResponseEntity<Void> usersUserIDPaymentsPost(@Min(1) Long userID, @Valid PaymentsRequest paymentRequest) {
		return service.usersUserIDPaymentsPost(userID, paymentRequest);
	}

	@Override
	public ResponseEntity<MessageResponse> usersUserIDPut(@Min(1) Long userID, @Valid UserDataUpdate userdata) {
		return service.usersUserIDPut(userID, userdata);
	}

}
