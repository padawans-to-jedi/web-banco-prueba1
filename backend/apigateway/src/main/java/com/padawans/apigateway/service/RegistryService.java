package com.padawans.apigateway.service;

import org.springframework.http.ResponseEntity;

import com.example.generated.model.MessageResponse;
import com.example.generated.model.UserData;

public interface RegistryService {

	ResponseEntity<MessageResponse> registryPost( UserData userdata);
}
