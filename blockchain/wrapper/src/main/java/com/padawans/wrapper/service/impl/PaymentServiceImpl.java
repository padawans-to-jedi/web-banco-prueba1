package com.padawans.wrapper.service.impl;

import java.math.BigInteger;
import java.time.Instant;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import com.example.generated.model.PaymentRequest;
import com.example.generated.model.PaymentResponse;
import com.padawans.wrapper.contracts.DemoBank;
import com.padawans.wrapper.contracts.DemoBank.EventAddPaymentOrderEventResponse;
import com.padawans.wrapper.contracts.exceptions.SmartContractException;
import com.padawans.wrapper.contracts.service.ContractService;
import com.padawans.wrapper.contracts.utils.WalletMapper;
import com.padawans.wrapper.service.PaymentService;


@Service
public class PaymentServiceImpl implements PaymentService {

	
	private static final Log log = LogFactory.getLog(WalletMapper.class);
	
	@Autowired
	ContractService service;
	
	@Override
	public ResponseEntity<PaymentResponse> paymentsPaymentIDPost(String paymentID, PaymentRequest payment) {
	DemoBank contract =service.getDemoBank().orElseThrow(()-> new SmartContractException("No se ha podido recurar el smart contract"));
	try {
		TransactionReceipt tx = contract.addPaymentOrder(new BigInteger(payment.getDebitorID().toString()), new BigInteger(paymentID), new BigInteger(payment.getCreditorID().toString()), new BigInteger(payment.getAmount().toString())).send();
		log.info("transactionHash for "+paymentID+" -> "+tx.getTransactionHash());
		PaymentResponse response = new PaymentResponse();
		response.setBlocknumber(tx.getBlockNumber().longValue());
		response.setTransactionHash(tx.getTransactionHash());
		response.setTimestamp(Instant.now().toEpochMilli());
		tx.getLogs().get(0).getTopics().forEach(t -> log.info(t));
		return new ResponseEntity<PaymentResponse>(response,HttpStatus.OK);
	} catch (Exception e) {
		throw new SmartContractException("No se ha ejecutar la transaccion debido a : "+e.getMessage());
	}
	
	}
	
}
