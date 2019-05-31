package com.padawans.wrapper.service;

import org.springframework.http.ResponseEntity;

import com.example.generated.model.PaymentRequest;
import com.example.generated.model.PaymentResponse;

public interface PaymentService {

	
	 ResponseEntity<PaymentResponse> paymentsPaymentIDPost(String paymentID,  PaymentRequest payment);
}
