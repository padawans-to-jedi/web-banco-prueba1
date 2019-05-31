package com.padawans.wrapper.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.generated.model.PaymentRequest;
import com.example.generated.model.PaymentResponse;
import com.padawans.wrapper.service.PaymentService;


@Service
public class PaymentServiceImpl implements PaymentService {

	@Override
	public ResponseEntity<PaymentResponse> paymentsPaymentIDPost(String paymentID, PaymentRequest payment) {
		// TODO Auto-generated method stub
		return null;
	}

}
