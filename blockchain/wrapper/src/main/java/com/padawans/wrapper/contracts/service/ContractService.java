package com.padawans.wrapper.contracts.service;

import java.util.Optional;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import com.padawans.wrapper.contracts.DemoBank;

public interface ContractService {

	
	 DemoBank loadContract(Credentials credentials);
	 Optional<DemoBank> getDemoBank() ;
	 TransactionReceipt getTransactionReceipt (String txHash);
	
}
