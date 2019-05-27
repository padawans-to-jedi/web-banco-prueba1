package com.liberbank.mailsender.service;

import org.springframework.http.ResponseEntity;

public interface MailsService {

	ResponseEntity<Void> sendSimpleMessage(String to, String subject, String text);
	
}
