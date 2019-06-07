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
import com.padawans.hackaton.generated.model.AccountsGetResponse;
import com.padawans.hackaton.generated.model.Event;
import com.padawans.hackaton.generated.model.MessageResponse;
import com.padawans.hackaton.generated.model.UserDataUpdate;

@Controller
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT })
public class UsersController implements UsersApi {

    @Autowired
    UserService service;

    @Override
    public ResponseEntity<AccountsGetResponse> usersUserIDAccountsGet(String token, @Min(1) Long userID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<Event> usersUserIDEventsEventIDGet(String token, @Min(1) Long userID, @Min(1) Long eventID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<Void> usersUserIDEventsEventIDPaymentsPost(String token, @Min(1) Long userID,
            @Min(1) Long eventID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<Void> usersUserIDEventsEventIDPost(String token, @Min(1) Long userID, @Min(1) Long eventID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<Void> usersUserIDEventsPost(String token, @Min(1) Long userID, @Min(1) Long eventID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<MessageResponse> usersUserIDPut(String token, @Min(1) Long userID,
            @Valid UserDataUpdate userdata) {
        // TODO Auto-generated method stub
        return null;
    }

}
