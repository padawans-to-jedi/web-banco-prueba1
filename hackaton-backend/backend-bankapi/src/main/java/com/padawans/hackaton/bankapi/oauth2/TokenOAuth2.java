package com.padawans.hackaton.bankapi.oauth2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.padawans.hackaton.bankapi.generated.model.AccessTokenResponse;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class TokenOAuth2 {

	@Value("${app.oauth2.api.identification}")
	String identification;

	@Value("${app.oauth2.api.token}")
	String apiToken;

	@Value("${app.oauth2.api.username}")
	String username;

	@Value("${app.oauth2.api.password}")
	String password;

	@Value("${app.oauth2.api.clientId}")
	String clientId;

	@Value("${app.oauth2.api.clientSecret}")
	String clientSecret;

	public TokenOAuth2(TokenData tokenData) {
		this.identification = tokenData.getIdentification();
		this.apiToken = tokenData.getApiToken();
		this.username = tokenData.getUsername();
		this.password = tokenData.getPassword();
		this.clientId = tokenData.getClientId();
		this.clientSecret = tokenData.getClientSecret();
	}

	public String getAccessTokenFromLiberbankForAccounts() {
		// ResourceOwnerPasswordResourceDetails resourceDetails = new
		// ResourceOwnerPasswordResourceDetails();
		//
		// resourceDetails.setId(identification);
		// resourceDetails.setAccessTokenUri(apiToken);
		// resourceDetails.setClientId(clientId);
		// resourceDetails.setClientSecret(clientSecret);
		//
		// resourceDetails.setGrantType("client_credentials");
		// resourceDetails.setScope(Arrays.asList("accountsList"));
		//
		// AccessTokenRequest atr = new DefaultAccessTokenRequest();
		// DefaultOAuth2ClientContext clientContext = new
		// DefaultOAuth2ClientContext(atr);
		//
		// OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails,
		// clientContext);
		// restTemplate.setMessageConverters(Arrays.asList(new
		// MappingJackson2HttpMessageConverter()));
		// String accessTokenFromLiberbank = restTemplate.getAccessToken().getValue();
		RestTemplate restTemplate;
		HttpEntity<MultiValueMap<String, String>> request;
		ResponseEntity<AccessTokenResponse> response = null;
		String accessTokenFromLiberbank = null;

		restTemplate = new RestTemplate();
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("grant_type", "client_credentials");
		map.add("client_id", clientId);
		map.add("client_secret", clientSecret);
		map.add("scope", "accountsList");

		request = new HttpEntity<>(map, getHeaders());

		String url = apiToken;
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

		String uri = builder.toUriString();

		try {
			response = restTemplate.postForEntity(uri, request, AccessTokenResponse.class);
		} catch (final HttpClientErrorException e) {
			log.info(e.getStatusCode().toString());
			log.info(e.getResponseBodyAsString());
		}

		if (response != null && response.getStatusCode() == HttpStatus.OK) {
			accessTokenFromLiberbank = response.getBody().getAccessToken();
		}

		log.debug("Access-Token from OAuth2 Padawans Liberbank: {}", accessTokenFromLiberbank);
		return accessTokenFromLiberbank;
	}

	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/x-www-form-urlencoded");

		return headers;
	}
}
