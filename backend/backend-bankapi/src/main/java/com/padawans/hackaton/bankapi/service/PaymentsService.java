package com.padawans.hackaton.bankapi.service;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.padawans.hackaton.bankapi.generated.model.PaymentInitiationRequest;
import com.padawans.hackaton.bankapi.generated.model.PaymentInitiationResponse;
import com.padawans.hackaton.bankapi.generated.model.PaymentResponse;

public interface PaymentsService {

	ResponseEntity<PaymentInitiationResponse> paymentsPaymentProductPost(String paymentProduct, String psUIPAddress,
			UUID xRequestId, @Valid PaymentInitiationRequest postReqBodyPayments);

	ResponseEntity<PaymentResponse> paymentsPaymentProductPaymentIdGet(String psUIPAddress, String xRequestId);

}
