package com.padawans.hackaton.bankapi.service.impl;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.padawans.hackaton.bankapi.generated.model.PaymentInitiationRequest;
import com.padawans.hackaton.bankapi.generated.model.PaymentInitiationResponse;
import com.padawans.hackaton.bankapi.generated.model.PaymentResponse;
import com.padawans.hackaton.bankapi.oauth2.TokenData;
import com.padawans.hackaton.bankapi.oauth2.TokenOAuth2;
import com.padawans.hackaton.bankapi.properties.LiberbankOauth2Properties;
import com.padawans.hackaton.bankapi.service.PaymentsService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentsServiceImpl implements PaymentsService {

	@Autowired
	LiberbankOauth2Properties properties;

	/**
	 * usar este postReqBodyPayments
	 * 
	 * { "endToEndIdentification": "3456345623457", "debtorAccount": { "iban":
	 * "ES0000000000000000000000", "currency": "EUR" }, "instructedAmount": {
	 * "currency": "EUR", "amount": 10 }, "creditorAccount": { "iban":
	 * "ES0000000000000000000000", "currency": "EUR" }, "creditorAgent":
	 * "337562046", "creditorName": "Pedro García Hidalgo", "creditorAddress": {
	 * "street": "Fuente de la mora", "buildingNumber": "2", "city": "Madrid",
	 * "postalCode": "28050", "countryCode": "ESP" },
	 * "remittanceInformationUnstructured":
	 * "ufaajitaweromlubomunugodsahbipulafueguukibugbakagofnuuzowenesigakfezsurevaglohupilozjuvevsamvozanagrahu",
	 * "requestedExecutionDate": "2017-07-21" }
	 */
	@Override
	public ResponseEntity<PaymentInitiationResponse> paymentsPaymentProductPost(String paymentProduct,
			String psUIPAddress, UUID xRequestId, @Valid PaymentInitiationRequest postReqBodyPayments) {
		HttpHeaders headers = getLiberbankHeaderForPayments(psUIPAddress, xRequestId);

		RestTemplate restTemplate;
		HttpEntity<PaymentInitiationRequest> request;
		ResponseEntity<PaymentInitiationResponse> response = null;

		restTemplate = new RestTemplate();

		request = new HttpEntity<>(postReqBodyPayments, headers);

		String url = "https://api-glbk.liberbank.es/tpps/sb/psd2/v1.0/payments/";

		String uri = UriComponentsBuilder.fromHttpUrl(url).path(paymentProduct).toUriString();

		try {
			response = restTemplate.postForEntity(uri, request, PaymentInitiationResponse.class);
		} catch (final HttpClientErrorException e) {
			log.info(e.getStatusCode().toString());
			log.info(e.getResponseBodyAsString());
		}

		return response;
	}

	@Override
	public ResponseEntity<PaymentResponse> paymentsPaymentProductPaymentIdGet(String psUIPAddress, String xRequestId) {
		// TODO Auto-generated method stub
		return null;
	}

	private HttpHeaders getLiberbankHeaderForPayments(String psUIPAddress, UUID xRequestId) {
		TokenData tokenData = new TokenData(properties);

		TokenOAuth2 tokenGenerator = new TokenOAuth2(tokenData);

		HttpHeaders headers = new HttpHeaders();
		headers.add("content-type", "application/json");
		headers.add("accept", "application/json");
		headers.add("PSU-IP-Address", psUIPAddress.toString());
		headers.add("x-request-id", xRequestId.toString());

		headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + tokenGenerator.getAccessTokenFromLiberbankForPayments());

		return headers;
	}

}
