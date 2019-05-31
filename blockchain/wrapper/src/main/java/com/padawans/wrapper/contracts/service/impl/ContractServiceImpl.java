package com.padawans.wrapper.contracts.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.Wallet;
import org.web3j.crypto.WalletFile;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;

import com.padawans.wrapper.contracts.DemoBank;
import com.padawans.wrapper.contracts.exceptions.SmartContractException;
import com.padawans.wrapper.contracts.service.ContractService;
import com.padawans.wrapper.contracts.utils.WalletMapper;

@Service
public class ContractServiceImpl implements ContractService{

	
	private static final String SC_ADDRESS = "0x14d6AaFEf2c34e6D6B8D9ACF049A1EeA811Cc312";
	private static final String HOST = "http://127.0.0.1:8543";
	private static  final String ACCOUNT ="{\"address\":\"ec6fcc3816f3bcf1af5c1a250ac5eded46f5cae7\",\"crypto\":{\"cipher\":\"aes-128-ctr\",\"ciphertext\":\"636aaf3b51d533e1419d6ae8a1745d5bd44f887735c8eefd36bef4b40910f547\",\"cipherparams\":{\"iv\":\"8a375ab289ce6f59905eac11c684befb\"},\"kdf\":\"scrypt\",\"kdfparams\":{\"dklen\":32,\"n\":262144,\"p\":1,\"r\":8,\"salt\":\"6350ddac96ea77596630067837afdfd2998afaf30cdf9ca825acd1a7f7ecac1b\"},\"mac\":\"7a37a84555fde9525f9b188a901014cfb58e1d6810f892dd4ba8abe7617461e1\"},\"id\":\"71a672d8-d7d0-4f9a-a3a0-9864de297c34\",\"version\":3}";
	private static  final String PASS ="123456789";
	
	@Autowired
	ContractGasProvider contractGasProvider;
	
	@Override
	public DemoBank loadContract(Credentials credentials) {
		final Web3j web3j = Web3j.build(new HttpService(HOST));
		DemoBank contract =DemoBank.load(SC_ADDRESS, web3j, credentials, contractGasProvider );
		
		return contract;
	}

	@Override
	public Optional<DemoBank> getDemoBank() {
		DemoBank notary = null;
		WalletFile walletFile = WalletMapper.getWallet(ACCOUNT);
		Credentials credentials;
		try {
			credentials = Credentials.create(Wallet.decrypt(PASS, walletFile));
		} catch (CipherException e) {
			throw new SmartContractException("The credentials could not be created. Error: " + e.getMessage());
		}
			 notary = loadContract(credentials);
		Optional<DemoBank>optional = Optional.ofNullable(notary);
		return optional;
		
	}

}
