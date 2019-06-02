package com.padawans.hackaton.apigateway.service;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.http.ResponseEntity;

import com.padawans.hackaton.generated.model.Accountrequest;
import com.padawans.hackaton.generated.model.AccountsGetResponse;
import com.padawans.hackaton.generated.model.AccountsResponse;
import com.padawans.hackaton.generated.model.MessageResponse;
import com.padawans.hackaton.generated.model.PaymentsRequest;
import com.padawans.hackaton.generated.model.UserDataUpdate;

public interface UserService {

	public ResponseEntity<AccountsGetResponse> usersUserIDAccountsGet(@Min(1) Long userID);

	public ResponseEntity<AccountsResponse> usersUserIDAccountsPost(@Min(1) Long userID,
			@Valid Accountrequest accountRequest);

	public ResponseEntity<Void> usersUserIDPaymentsPost(@Min(1) Long userID, @Valid PaymentsRequest paymentRequest);

	public ResponseEntity<MessageResponse> usersUserIDPut(@Min(1) Long userID, @Valid UserDataUpdate userdata);

}
