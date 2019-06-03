package com.padawans.wrapper.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.generated.api.PaymentsApi;
import com.example.generated.model.PaymentRequest;
import com.example.generated.model.PaymentResponse;
import com.padawans.wrapper.service.PaymentService;


@Controller
@CrossOrigin(origins= {"*"} ,maxAge = 3600)
public class PaymentsController implements PaymentsApi{

	@Autowired
	PaymentService service;
	
	@Override
	public ResponseEntity<PaymentResponse> paymentsPaymentIDPost(String paymentID, @Valid PaymentRequest payment) {
		return service.paymentsPaymentIDPost(paymentID, payment);
	}

}
