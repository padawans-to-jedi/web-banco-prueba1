package com.padawans.hackaton.bankapi.service;

import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.padawans.hackaton.bankapi.generated.model.Body;
import com.padawans.hackaton.bankapi.generated.model.FundsAvailableResponse;

public interface FoundsConfirmationService {

	ResponseEntity<FundsAvailableResponse> fundsConfirmationPost(UUID xRequestID, Body body);

}
