package com.padawans.wrapper.contracts.service;

import java.util.Optional;

import org.web3j.crypto.Credentials;

import com.padawans.wrapper.contracts.DemoBank;

public interface ContractService {

	
	Optional<DemoBank> loadContract(Credentials credentials);
	 Optional<DemoBank> getDemoBank() ;
	
}
