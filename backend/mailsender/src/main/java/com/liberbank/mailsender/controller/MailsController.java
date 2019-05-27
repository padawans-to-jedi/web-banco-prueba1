package com.liberbank.mailsender.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.generated.api.MailsApi;
import com.example.generated.model.MailRequest;
import com.liberbank.mailsender.service.MailsService;


@Controller
@CrossOrigin(origins = "*", methods= {RequestMethod.POST})
public class MailsController implements MailsApi{

	@Autowired
	MailsService service;
	@Override
	public ResponseEntity<Void> mailsPost(@Valid MailRequest request) {
		return service.sendSimpleMessage(request.getTo(),request.getSubject() , request.getBody());
	}

}
