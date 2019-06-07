package com.liberbank.apigateway.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.generated.api.UsersApi;
import com.example.generated.model.Accountrequest;
import com.example.generated.model.AccountsGetResponse;
import com.example.generated.model.AccountsResponse;
import com.example.generated.model.MessageResponse;
import com.example.generated.model.PaymentsRequest;
import com.example.generated.model.UserDataUpdate;
import com.liberbank.apigateway.service.UserService;

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
    public ResponseEntity<MessageResponse> usersUserIDPut(@Min(1) Long userID, @Valid UserDataUpdate userdata) {
        return service.usersUserIDPut(userID, userdata);
    }

    @Override
    public ResponseEntity<Void> usersUserIDPaymentsPost(@Min(1) Long userID, PaymentsRequest paymentRequest) {
        // TODO Auto-generated method stub
        return null;
    }

}
