package com.padawans.apigateway.utils;

import com.example.generated.model.Address;
import com.padawans.apigateway.dao.AddressDAO;

public class DataUtils {
	
	public static AddressDAO getAdressFromRequest(Address data) {
		return new AddressDAO(data.getStreet(), data.getCountry(),data.getNumber() , data.getFloor(), data.getPostalCode());
	}

}
