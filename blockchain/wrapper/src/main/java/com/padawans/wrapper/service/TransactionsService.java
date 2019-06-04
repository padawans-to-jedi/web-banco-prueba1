package com.padawans.wrapper.service;

import org.springframework.http.ResponseEntity;

import com.example.generated.model.TransactionResponse;

public interface TransactionsService {

	ResponseEntity<TransactionResponse> transactionsTransactionHashGet(String transactionHash);
	
}
