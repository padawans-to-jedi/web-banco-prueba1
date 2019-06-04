package com.padawans.wrapper.contracts.service.impl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.Wallet;
import org.web3j.crypto.WalletFile;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;

import com.padawans.wrapper.contracts.DemoBank;
import com.padawans.wrapper.contracts.exceptions.SmartContractException;
import com.padawans.wrapper.contracts.service.ContractService;
import com.padawans.wrapper.contracts.utils.WalletMapper;

@Service
public class ContractServiceImpl implements ContractService{

	
	private static final String SC_ADDRESS = "0xc4050657743483991aC5592337C503ceE7167266";
	private static final String HOST = "http://127.0.0.1:8550";
	private static  final String ACCOUNT ="{\"address\":\"6829286953334c097b354cc5122edfcbeb862f1c\",\"crypto\":{\"cipher\":\"aes-128-ctr\",\"ciphertext\":\"c25e39d5443a0d6502a7a85a9bb0c6ef74855d423cdd5267b3d40c5fdfec6d3d\",\"cipherparams\":{\"iv\":\"bff44106954e58d73a64831c9c590274\"},\"kdf\":\"scrypt\",\"kdfparams\":{\"dklen\":32,\"n\":262144,\"p\":1,\"r\":8,\"salt\":\"e45ab2681721765f11d1ee951ece6e7e01909b1b076d3e9eb16f8afb26fdd0ed\"},\"mac\":\"8c672bb7be72a542f34d5e65b7f32e227a95c262a65a5ca27aec56bd6ec4eecc\"},\"id\":\"84824c2c-403e-49da-8641-e76bbe653bd3\",\"version\":3}";
	private static  final String PASS ="123456789";
	private static final  Web3j web3j = Web3j.build(new HttpService(HOST));
	
	
	@Autowired
	ContractGasProvider contractGasProvider;
	
	@Override
	public DemoBank loadContract(Credentials credentials) {
		
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

	@Override
	public TransactionReceipt getTransactionReceipt(String txHash) {
		try {
			TransactionReceipt transactionReceipt = 
				    web3j.ethGetTransactionReceipt(txHash).send().getTransactionReceipt().orElseThrow(()-> new SmartContractException("No existe informacion de transaccion"));
			return transactionReceipt;
		} catch (IOException e) {
			throw new SmartContractException("No se ha podido recuperar La informacion de transaccion. Error: " + e.getMessage());
		}
		
	}
	
	

}
