package com.padawans.wrapper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import com.example.generated.model.TransactionResponse;
import com.padawans.wrapper.contracts.DemoBank;
import com.padawans.wrapper.contracts.DemoBank.EventAddPaymentOrderEventResponse;
import com.padawans.wrapper.contracts.exceptions.SmartContractException;
import com.padawans.wrapper.contracts.service.ContractService;
import com.padawans.wrapper.service.TransactionsService;


@Service
public class TransactionServiceImpl implements TransactionsService{

	@Autowired
	ContractService service;
	
	@Override
	public ResponseEntity<TransactionResponse> transactionsTransactionHashGet(String transactionHash) {
		DemoBank contract =service.getDemoBank().orElseThrow(()-> new SmartContractException("No se ha podido recurar el smart contract"));
		try {
			TransactionReceipt tx = service.getTransactionReceipt(transactionHash);
			EventAddPaymentOrderEventResponse event = contract.getEventAddPaymentOrderEvents(tx).get(0);
			TransactionResponse response = new TransactionResponse();
			response.setDebitorID(event.userId.longValue());
			response.setCreditorID(event.paymentType.intValue());
			response.setAmount(event.amount.longValue());
			response.setPaymentID(event.orderId.intValue());
			return new ResponseEntity<TransactionResponse>(response,HttpStatus.OK);
		} catch (Exception e) {
			throw new SmartContractException("No se ha recuperar la transaccion debido a : "+e.getMessage());
		}
	}

}
