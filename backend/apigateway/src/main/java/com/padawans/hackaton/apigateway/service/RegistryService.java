package com.padawans.hackaton.apigateway.service;

import org.springframework.http.ResponseEntity;

import com.padawans.hackaton.generated.api.RegistryApi;
import com.padawans.hackaton.generated.model.MessageResponse;
import com.padawans.hackaton.generated.model.UserData;

public interface RegistryService extends RegistryApi {

	ResponseEntity<MessageResponse> registryPost(UserData userdata);
}
