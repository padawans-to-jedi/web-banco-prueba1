package com.padawans.jwt.controller;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.padawans.jwt.message.request.UpdateFrom;
import com.padawans.jwt.model.User;
import com.padawans.jwt.repository.UserRepository;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AplicationController {
	private static final Log LOG = LogFactory.getLog(AplicationController.class);
	
	@Autowired
	private UserRepository repository;

	@GetMapping("/api/users/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<User> getUserInfo(@PathVariable("id") long id) {
		Optional<User> user = repository.findById(id);
		if (user.isPresent()) {
			return new ResponseEntity<User>(user.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/api/admins/users")
	@PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = repository.findAll();
		if (users.size() > 0) {
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/api/users")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<User> getUsersbyName(@RequestParam(value = "userName", defaultValue = "") String username) {
		Optional<User> user = repository.findByUsername(username);
		
		if (user.isPresent()) {
			LOG.info("User data--> "+user.toString());
			return new ResponseEntity<User>(user.get(), HttpStatus.OK);
		}
		LOG.info("Usuario no encontrado");
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/api/users/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<User> putUsers(@PathVariable("id") long id, @RequestBody UpdateFrom form) {
		Optional<User> user = repository.findById(id);
		if (user.isPresent()) {
			User result = user.get();
			LOG.info(result.toString());
			result.setName(form.getName());
			result.setPhone(form.getPhone());
			result.setSurname(form.getSurname());
			User response =  repository.saveAndFlush(user.get());
			
				if(result.getUsername().equalsIgnoreCase(response.getUsername()))return new ResponseEntity<User>(user.get(),HttpStatus.OK);
			LOG.warn("El userName de modificacion -> "+result.getUsername()+" nocoincide con -> "+response.getUsername());
			LOG.warn(response.toString());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
