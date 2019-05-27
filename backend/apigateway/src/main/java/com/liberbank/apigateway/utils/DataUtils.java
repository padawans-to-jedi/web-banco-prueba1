package com.liberbank.apigateway.utils;

import com.example.generated.model.Address;
import com.example.generated.model.LoginResponse;
import com.liberbank.apigateway.dao.AddressDAO;
import com.liberbank.apigateway.dao.UserDAO;

public class DataUtils {
	
	public static AddressDAO getAdressFromRequest(Address data) {
		return new AddressDAO(data.getStreet(), data.getCountry(),data.getNumber() , data.getFloor(), data.getPostalCode());
	}
	
	public static LoginResponse userDAOToLoginResponse(UserDAO user, String bearer) {
		LoginResponse result = new LoginResponse();
		result.setBearer(bearer);
		result.setEmail(user.getUserName());
		result.setName(user.getName());
		result.setSurname(user.getSurname());
		result.setUserID(user.getId().intValue());
		result.setPhone(user.getPhone());
		result.setAddress(addressDAOToAddress(user.getAddress()));
		return result;
		
	}

	public static Address addressDAOToAddress(AddressDAO address) {
		Address result = new Address();
		result.setCountry(address.getCountry());
		result.setFloor(address.getFloor());
		result.setNumber(address.getNumber());
		result.setStreet(address.getStreet());
		result.setPostalCode(address.getPostalCode());
		return result;
	}
}
