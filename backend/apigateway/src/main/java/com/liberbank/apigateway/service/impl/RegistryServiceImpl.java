package com.liberbank.apigateway.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.generated.model.MessageResponse;
import com.example.generated.model.UserData;
import com.liberbank.apigateway.dao.AddressDAO;
import com.liberbank.apigateway.dao.UserDAO;
import com.liberbank.apigateway.exceptions.UserRepositoryException;
import com.liberbank.apigateway.repository.AddressRepository;
import com.liberbank.apigateway.repository.UserRpository;
import com.liberbank.apigateway.service.RegistryService;
import com.liberbank.apigateway.utils.DataUtils;

@Service
public class RegistryServiceImpl implements RegistryService {

	private static final Log LOG = LogFactory.getLog(RegistryServiceImpl.class);

	@Autowired
	UserRpository userRepository;
	
	@Autowired 
	AddressRepository addressRepository;

	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public ResponseEntity<MessageResponse> registryPost(UserData userdata) {
		LOG.info(userdata.toString());
		LOG.info("INICIANDO REGISTRO USUARIO---> " + userdata.getName());
		if (userRepository.existsByUserName(userdata.getEmail())) {
			LOG.info("Fail -> Username is already taken!");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		UserDAO user = new UserDAO(userdata.getName(), userdata.getSurname(), userdata.getPhone(), userdata.getEmail(),
				null, encoder.encode(userdata.getPassword().toUpperCase()),null);
		AddressDAO address = DataUtils.getAdressFromRequest(userdata.getAddress());
		
		
		try {
			user.setAddress(address);
			address.setUser(user);
			userRepository.save(user);
		} catch (Exception e) {
			throw new UserRepositoryException("El ususario no ha podido registrarse. Debido a : "+e.getMessage());
		}
		
		MessageResponse message = new MessageResponse();
		LOG.info("REGISTRO USUARIO COMPLETADO  PARA EL USUARIO-> " + user.getUserName());
		message.setHttpStatus(201);
		message.setMessage("Usuario Registrado");
		message.setTimestamp(new Timestamp(new Date().getTime()).toString());
		message.setReasonPhrase("CREATED");
		return new ResponseEntity<MessageResponse>(message, HttpStatus.CREATED);

	}

}
