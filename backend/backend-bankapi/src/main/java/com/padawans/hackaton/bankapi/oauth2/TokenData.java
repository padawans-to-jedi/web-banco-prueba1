package com.padawans.hackaton.bankapi.oauth2;

import org.springframework.stereotype.Component;

import com.padawans.hackaton.bankapi.properties.LiberbankOauth2Properties;

import lombok.Data;

@Component
@Data
public class TokenData {

    String identification;

    String apiToken;

    String username;

    String password;

    String clientId;

    String clientSecret;

    public TokenData(LiberbankOauth2Properties properties) {
        identification = properties.getIdentification();
        apiToken = properties.getApiToken();
        username = properties.getUsername();
        password = properties.getPassword();
        clientId = properties.getClientId();
        clientSecret = properties.getClientSecret();
    }
}
