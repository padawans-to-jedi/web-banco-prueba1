package com.padawans.hackaton.apigateway.service.impl;

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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.padawans.hackaton.apigateway.oauth2.TokenData;
import com.padawans.hackaton.apigateway.oauth2.TokenOAuth2;
import com.padawans.hackaton.apigateway.properties.LiberbankOauth2Properties;
import com.padawans.hackaton.apigateway.service.AccountService;
import com.padawans.hackaton.generated.model.AccountsDto;
import com.padawans.hackaton.generated.model.BalancesResponseDto;
import com.padawans.hackaton.generated.model.TransactionResponseDto;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	LiberbankOauth2Properties properties;

	@Override
	public ResponseEntity<BalancesResponseDto> accountsAccountIdBalancesGet(String accountId, UUID xRequestId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<TransactionResponseDto> accountsAccountIdTransactionsGet(String accountId, UUID xRequestId,
			Date dateFrom, Date dateTo, String count, String cursor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<AccountsDto> accountsGet(UUID xRequestId, String count, String cursor) {
		HttpHeaders headers = getLiberbankHeaderForAccounts();

		URI uri = null;
		try {
			uri = new URI(
					UriComponentsBuilder.newInstance().host("https://api-glbk.liberbank.es/tpps/sb/psd2/v1.0/accounts")
							.queryParam(cursor, "3yvu1pzhd3i7").toUriString());
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		RequestEntity<AccountsDto> request = new RequestEntity<AccountsDto>(headers, HttpMethod.GET, uri);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<AccountsDto> response = null;

		try {
			response = restTemplate.exchange(request, AccountsDto.class);
		} catch (Exception e) {
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
