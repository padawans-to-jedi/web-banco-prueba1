package com.padawans.hackaton.apigateway.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
public class LiberbankOauth2Properties {

	@Value("${app.oauth2.apim.url}")
	private String apimUrl;

	@Value("${app.oauth2.apim.customerUri}")
	private String customerUri;

	@Value("${app.oauth2.apim.contractUri}")
	private String contractUri;

	@Value("${app.oauth2.apim.wso2.identification}")
	private String identification;

	@Value("${app.oauth2.apim.wso2.apiToken}")
	private String apiToken;

	@Value("${app.oauth2.apim.wso2.username}")
	private String username;

	@Value("${app.oauth2.apim.wso2.password}")
	private String password;

	@Value("${app.oauth2.apim.wso2.clientId}")
	private String clientId;

	@Value("${app.oauth2.apim.wso2.clientSecret}")
	private String clientSecret;

}
