package com.padawans.hackaton.bankapi.oauth2;

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

@Log4j2
@Component
public class TokenOAuth2 {

    String identification;

    String apiUrlToken;

    String username;

    String password;

    String clientId;

    String clientSecret;

    public TokenOAuth2(TokenData tokenData) {
        this.identification = tokenData.getIdentification();
        this.apiUrlToken = tokenData.getApiToken();
        this.username = tokenData.getUsername();
        this.password = tokenData.getPassword();
        this.clientId = tokenData.getClientId();
        this.clientSecret = tokenData.getClientSecret();
    }

    public String getAccessTokenFromLiberbankForAccount() {
        return getTokenByScope("accountsList");
    }

    public String getAccessTokenFromLiberbankForAccountBalances() {
        return getTokenByScope("accountDetails");
    }

    public String getAccessTokenFromLiberbankForAccountTransactions() {
        return getTokenByScope("accountDetails");
    }

    private String getTokenByScope(String scope) {
        RestTemplate restTemplate;
        HttpEntity<MultiValueMap<String, String>> request;
        ResponseEntity<AccessTokenResponse> response = null;
        String accessTokenFromLiberbank = null;

        restTemplate = new RestTemplate();
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "client_credentials");
        map.add("client_id", clientId);
        map.add("client_secret", clientSecret);
        map.add("scope", scope);

        request = new HttpEntity<>(map, getHeaders());

        String uri = UriComponentsBuilder.fromHttpUrl(apiUrlToken).toUriString();

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
