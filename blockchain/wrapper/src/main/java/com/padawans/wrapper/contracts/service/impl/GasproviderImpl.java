package com.padawans.wrapper.contracts.service.impl;

import java.math.BigInteger;

import org.springframework.stereotype.Component;
import org.web3j.tx.gas.ContractGasProvider;

@Component
public class GasproviderImpl implements ContractGasProvider{
	
	 @Override
	    public BigInteger getGasPrice(String contractFunc) {
	        return BigInteger.valueOf(1000000000);
	    }

	    @Override
	    public BigInteger getGasPrice() {
	        return BigInteger.valueOf(1000000000);
	    }

	    @Override
	    public BigInteger getGasLimit(String contractFunc) {
	        return BigInteger.valueOf(2000000);
	    }

	    @Override
	    public BigInteger getGasLimit() {
	        return BigInteger.valueOf(2000000);
	    }


}
