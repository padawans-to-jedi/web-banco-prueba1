package com.padawans.hackaton.bankapi.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
public class LiberbankOauth2Properties {

    @Value("${app.oauth2.api.identification}")
    private String identification;

    @Value("${app.oauth2.api.url}")
    private String apiUrl;

    @Value("${app.oauth2.api.token}")
    private String apiToken;

    @Value("${app.oauth2.api.username}")
    private String username;

    @Value("${app.oauth2.api.password}")
    private String password;

    @Value("${app.oauth2.api.clientId}")
    private String clientId;

    @Value("${app.oauth2.api.clientSecret}")
    private String clientSecret;

}
