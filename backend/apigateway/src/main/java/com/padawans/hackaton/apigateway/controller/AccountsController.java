package com.padawans.hackaton.apigateway.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.padawans.hackaton.apigateway.service.AccountService;
import com.padawans.hackaton.generated.api.AccountsApi;
import com.padawans.hackaton.generated.model.AccountsDto;
import com.padawans.hackaton.generated.model.BalancesResponseDto;
import com.padawans.hackaton.generated.model.TransactionResponseDto;

@Controller
@CrossOrigin(origins = "*", methods = { RequestMethod.GET })
public class AccountsController implements AccountsApi {

	@Autowired
	AccountService accountService;

	@Override
	public ResponseEntity<BalancesResponseDto> accountsAccountIdBalancesGet(String accountId, UUID xRequestId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<TransactionResponseDto> accountsAccountIdTransactionsGet(String accountId, UUID xRequestId,
			Date dateFrom, Date dateTo, String count, String cursor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<AccountsDto> accountsGet(UUID xRequestId, String count, String cursor) {
		// TODO Auto-generated method stub
		return accountService.accountsGet(xRequestId, count, cursor);
	}

}
