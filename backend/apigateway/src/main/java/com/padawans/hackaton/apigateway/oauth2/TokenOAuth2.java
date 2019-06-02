package com.padawans.hackaton.apigateway.oauth2;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class TokenOAuth2 {

	@Value("${app.oauth2.identification}")
	String identification;

	@Value("${app.oauth2.apiToken}")
	String apiToken;

	@Value("${app.oauth2.username}")
	String username;

	@Value("${app.oauth2.password}")
	String password;

	@Value("${app.oauth2.clientId}")
	String clientId;

	@Value("${app.oauth2.clientSecret}")
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
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();

		resourceDetails.setId(identification);
		resourceDetails.setAccessTokenUri(apiToken);
		resourceDetails.setUsername(username);
		resourceDetails.setPassword(password);
		resourceDetails.setClientId(clientId);
		resourceDetails.setClientSecret(clientSecret);

		resourceDetails.setGrantType("client_credentials");
		resourceDetails.setScope(Arrays.asList("accountsList", "accountDetails"));

		AccessTokenRequest atr = new DefaultAccessTokenRequest();
		DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext(atr);

		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails, clientContext);
		restTemplate.setMessageConverters(Arrays.asList(new MappingJackson2HttpMessageConverter()));
		String accessTokenFromLiberbank = restTemplate.getAccessToken().getValue();
		log.debug("Access-Token from OAuth2 Padawans Liberbank: {}", accessTokenFromLiberbank);
		return accessTokenFromLiberbank;
	}
}
