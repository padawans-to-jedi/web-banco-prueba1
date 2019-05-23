package com.scs.jwtauthentication.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scs.jwtauthentication.message.request.LoginForm;
import com.scs.jwtauthentication.message.request.SignUpForm;
import com.scs.jwtauthentication.message.response.JwtResponse;
import com.scs.jwtauthentication.model.Role;
import com.scs.jwtauthentication.model.RoleName;
import com.scs.jwtauthentication.model.User;
import com.scs.jwtauthentication.model.UserResponse;
import com.scs.jwtauthentication.repository.RoleRepository;
import com.scs.jwtauthentication.repository.UserRepository;
import com.scs.jwtauthentication.security.jwt.JwtProvider;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {
	private static final Log LOG = LogFactory.getLog(AuthRestAPIs.class);

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;
    
    @Autowired
    AplicationController controller;
   

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        JwtResponse token = new JwtResponse(jwt);
        User user = controller.getUsersbyName(loginRequest.getUsername()).getBody();
        UserResponse response = new UserResponse(user.getId(), user.getName(), user.getSurname(), user.getUsername(), user.getPhone(), user.getEmail(), token);
        return ResponseEntity.ok(response);
    }
    
    

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
    	LOG.info(signUpRequest.toString());
    	LOG.info("INICIANDO REGISTRO USUARIO---> "+signUpRequest.getName());
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
        	LOG.info("Fail -> Username is already taken!");
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
        	LOG.info("Fail -> Email is already in use!");
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getName(),signUpRequest.getSurname(), signUpRequest.getUsername(),
        		signUpRequest.getPhone(),  signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
        	switch(role) {
	    		case "admin":
	    			Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
	                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	    			roles.add(adminRole);
	    			
	    			break;
	    		case "pm":
	            	Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
	                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	            	roles.add(pmRole);
	            	
	    			break;
	    		default:
	        		Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
	                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	        		roles.add(userRole);        			
        	}
        });
        
        user.setRoles(roles);
        LOG.info("Roles");
        for (Role item : roles) {
        	LOG.info("Rol--> "+item.toString());
		}
        userRepository.save(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}