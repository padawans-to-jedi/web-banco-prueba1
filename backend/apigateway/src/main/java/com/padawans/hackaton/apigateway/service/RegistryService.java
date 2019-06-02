package com.padawans.hackaton.apigateway.service;

import org.springframework.http.ResponseEntity;

import com.padawans.hackaton.generated.model.MessageResponse;
import com.padawans.hackaton.generated.model.UserData;

public interface RegistryService {

	ResponseEntity<MessageResponse> registryPost(UserData userdata);
}
