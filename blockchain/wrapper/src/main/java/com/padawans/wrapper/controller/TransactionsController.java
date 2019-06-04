package com.padawans.wrapper.controller;

import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.example.generated.api.TransactionsApi;
import com.example.generated.model.TransactionResponse;
import com.padawans.wrapper.service.TransactionsService;

@Controller
public class TransactionsController implements TransactionsApi{

	@Autowired
	TransactionsService service;
	
	@Override
	public ResponseEntity<TransactionResponse> transactionsTransactionHashGet(
			@Size(min = 60, max = 70) String transactionHash) {
		return service.transactionsTransactionHashGet(transactionHash);
	}

}
