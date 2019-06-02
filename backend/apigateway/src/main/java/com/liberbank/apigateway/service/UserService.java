package com.liberbank.apigateway.service;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.http.ResponseEntity;

import com.example.generated.model.Accountrequest;
import com.example.generated.model.AccountsGetResponse;
import com.example.generated.model.AccountsResponse;
import com.example.generated.model.MessageResponse;
import com.example.generated.model.PaymentsRequest;
import com.example.generated.model.UserDataUpdate;

public interface UserService {

	
	
	public ResponseEntity<AccountsGetResponse> usersUserIDAccountsGet(@Min(1) Long userID);

	
	public ResponseEntity<AccountsResponse> usersUserIDAccountsPost(@Min(1) Long userID,
			@Valid Accountrequest accountRequest);

	public ResponseEntity<Void> usersUserIDPaymentsPost(@Min(1) Long userID, @Valid PaymentsRequest paymentRequest);


	public ResponseEntity<MessageResponse> usersUserIDPut(@Min(1) Long userID, @Valid UserDataUpdate userdata);
	
	
}
