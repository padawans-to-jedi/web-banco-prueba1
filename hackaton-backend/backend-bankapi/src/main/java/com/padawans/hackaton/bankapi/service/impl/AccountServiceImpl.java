package com.padawans.hackaton.bankapi.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.padawans.hackaton.bankapi.generated.model.AccountsResponse;
import com.padawans.hackaton.bankapi.generated.model.BalancesResponse;
import com.padawans.hackaton.bankapi.generated.model.TransactionResponse;
import com.padawans.hackaton.bankapi.oauth2.TokenData;
import com.padawans.hackaton.bankapi.oauth2.TokenOAuth2;
import com.padawans.hackaton.bankapi.properties.LiberbankOauth2Properties;
import com.padawans.hackaton.bankapi.service.AccountService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

	@Autowired
	LiberbankOauth2Properties properties;

	public ResponseEntity<BalancesResponse> accountsAccountIdBalancesGet(String accountId, UUID xRequestId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<TransactionResponse> accountsAccountIdTransactionsGet(String accountId, UUID xRequestId,
			Date dateFrom, Date dateTo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<AccountsResponse> accountsGet(UUID xRequestId) {
		HttpHeaders headers = getLiberbankHeaderForAccounts();

		// URI uri = null;
		// try {
		// uri = new URI(
		// UriComponentsBuilder.newInstance().host("https://api-glbk.liberbank.es/tpps/sb/psd2/v1.0/accounts")
		// .queryParam("cursor", "3yvu1pzhd3i7").toUriString());
		// } catch (URISyntaxException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		//

		String url = "https://api-glbk.liberbank.es/tpps/sb/psd2/v1.0/accounts?cursor=3yvu1pzhd3i7";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

		URI uri = null;
		try {
			uri = new URI(builder.toUriString());
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		RequestEntity<AccountsResponse> request = new RequestEntity<AccountsResponse>(headers, HttpMethod.GET, uri);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<AccountsResponse> response = null;

		try {
			response = restTemplate.exchange(request, AccountsResponse.class);
		} catch (final HttpClientErrorException e) {
			log.info(e.getStatusCode().toString());
			log.info(e.getResponseBodyAsString());
		}

		return response;
	}

	private HttpHeaders getLiberbankHeaderForAccounts() {
		TokenData tokenData = new TokenData();

		tokenData.setIdentification(properties.getIdentification());
		tokenData.setApiToken(properties.getApiToken());
		tokenData.setUsername(properties.getUsername());
		tokenData.setPassword(properties.getPassword());
		tokenData.setClientId(properties.getClientId());
		tokenData.setClientSecret(properties.getClientSecret());

		TokenOAuth2 tokenGenerator = new TokenOAuth2(tokenData);

		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + tokenGenerator.getAccessTokenFromLiberbankForAccounts());

		return headers;
	}

}
