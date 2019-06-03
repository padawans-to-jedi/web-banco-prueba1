package com.padawans.hackaton.bankapi.oauth2;

import org.springframework.stereotype.Component;

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
}
