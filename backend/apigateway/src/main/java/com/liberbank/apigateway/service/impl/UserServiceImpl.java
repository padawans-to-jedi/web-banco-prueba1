package com.liberbank.apigateway.service.impl;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.generated.model.Accountrequest;
import com.example.generated.model.AccountsGetResponse;
import com.example.generated.model.AccountsResponse;
import com.example.generated.model.MessageResponse;
import com.example.generated.model.PaymentsRequest;
import com.example.generated.model.UserDataUpdate;
import com.liberbank.apigateway.dao.AddressDAO;
import com.liberbank.apigateway.dao.UserDAO;
import com.liberbank.apigateway.exceptions.UserRepositoryException;
import com.liberbank.apigateway.repository.AccountRepository;
import com.liberbank.apigateway.repository.UserRpository;
import com.liberbank.apigateway.service.UserService;
import com.liberbank.apigateway.utils.DataUtils;


@Service
public class UserServiceImpl implements UserService {

	private static final Log log = LogFactory.getLog(UserServiceImpl.class);
	
	@Autowired
	UserRpository userRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public ResponseEntity<AccountsGetResponse> usersUserIDAccountsGet(@Min(1) Long userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<AccountsResponse> usersUserIDAccountsPost(@Min(1) Long userID,
			@Valid Accountrequest accountRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> usersUserIDPaymentsPost(@Min(1) Long userID, @Valid PaymentsRequest paymentRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<MessageResponse> usersUserIDPut(@Min(1) Long userID, @Valid UserDataUpdate userdata) {
		UserDAO user = userRepository.findById(userID).orElseThrow(() -> new UserRepositoryException("Usuario no Encontrado"));
		user.setPhone(userdata.getPhone());
		//user.setUserName(userdata.getEmail());
		try {
			userRepository.save(user);
		} catch (Exception e) {
			throw new UserRepositoryException("Usuario no actualizado debido a :"+e.getMessage());
		}
		MessageResponse  response = new MessageResponse();
		response.setHttpStatus(200);
		response.setReasonPhrase(HttpStatus.OK.getReasonPhrase());
		response.setMessage("El usuario "+user.getName()+" "+user.getSurname() +" se ha actualizado correctamente");
		return new ResponseEntity<MessageResponse>(response,HttpStatus.OK);
	}

}
