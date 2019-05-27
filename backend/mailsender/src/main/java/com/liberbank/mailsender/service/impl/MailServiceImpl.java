package com.liberbank.mailsender.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.liberbank.mailsender.exceptions.MailSeerviceException;
import com.liberbank.mailsender.service.MailsService;

@Component
public class MailServiceImpl implements MailsService {

	
	 @Autowired
	 public JavaMailSender emailSender;
	
	@Override
	public ResponseEntity<Void> sendSimpleMessage(String to, String subject, String text) {
		try {
			SimpleMailMessage message = new SimpleMailMessage(); 
	        message.setTo(to); 
	        message.setSubject(subject); 
	        message.setText(text);
	        emailSender.send(message);
		} catch (Exception e) {
			throw new MailSeerviceException("EL email no se ha enviado. Causa: "+e);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
