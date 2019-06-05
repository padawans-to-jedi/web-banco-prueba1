package com.padawans.hackaton.bankapi.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.padawans.hackaton.bankapi.generated.api.FundsConfirmationsApi;
import com.padawans.hackaton.bankapi.generated.model.Body;
import com.padawans.hackaton.bankapi.generated.model.FundsAvailableResponse;
import com.padawans.hackaton.bankapi.service.FoundsConfirmationService;

@Controller
public class FoundsConfirmationController implements FundsConfirmationsApi {

	@Autowired
	FoundsConfirmationService foundsConfirmationService;

	@Override
	public ResponseEntity<FundsAvailableResponse> fundsConfirmationsPost(UUID xRequestId, Body body) {
		// {
		// "cardNumber": "1196931787259904",
		// "account": {
		// "iban": "ES1020480000213004029736",
		// "currency": "EUR"
		// },
		// "payee": "John Marshall",
		// "instructedAmount": {
		// "currency": "EUR",
		// "amount": 1000
		// }
		// }
		return foundsConfirmationService.fundsConfirmationPost(xRequestId, body);
	}

}
