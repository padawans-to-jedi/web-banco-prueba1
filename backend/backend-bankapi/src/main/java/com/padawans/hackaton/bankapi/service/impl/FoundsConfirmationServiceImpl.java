package com.padawans.hackaton.bankapi.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.padawans.hackaton.bankapi.generated.model.Body;
import com.padawans.hackaton.bankapi.generated.model.FundsAvailableResponse;
import com.padawans.hackaton.bankapi.oauth2.TokenData;
import com.padawans.hackaton.bankapi.oauth2.TokenOAuth2;
import com.padawans.hackaton.bankapi.properties.LiberbankOauth2Properties;
import com.padawans.hackaton.bankapi.service.FoundsConfirmationService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FoundsConfirmationServiceImpl implements FoundsConfirmationService {

	@Autowired
	LiberbankOauth2Properties properties;

	public ResponseEntity<FundsAvailableResponse> fundsConfirmationPost(UUID xRequestId, Body body) {
		HttpHeaders headers = getLiberbankHeaderForPayments(xRequestId);

		RestTemplate restTemplate;
		HttpEntity<Body> request;
		ResponseEntity<FundsAvailableResponse> response = null;
		String accessTokenFromLiberbank = null;

		restTemplate = new RestTemplate();

		request = new HttpEntity<>(body, headers);

		String url = "https://api-glbk.liberbank.es/tpps/sb/psd2/v1.0/funds-confirmations";

		String uri = UriComponentsBuilder.fromHttpUrl(url).toUriString();

		try {
			response = restTemplate.postForEntity(uri, request, FundsAvailableResponse.class);
		} catch (final HttpClientErrorException e) {
			log.info(e.getStatusCode().toString());
			log.info(e.getResponseBodyAsString());
		}

		return response;
	}

	private HttpHeaders getLiberbankHeaderForPayments(UUID xRequestId) {
		TokenData tokenData = new TokenData(properties);

		TokenOAuth2 tokenGenerator = new TokenOAuth2(tokenData);

		HttpHeaders headers = new HttpHeaders();
		headers.add("content-type", "application/json");
		headers.add("accept", "application/json");
		headers.add("x-request-id", xRequestId.toString());
		headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + tokenGenerator.getAccessTokenFromLiberbankForPayments());

		return headers;
	}

}
