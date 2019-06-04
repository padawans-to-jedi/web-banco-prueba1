package com.padawans.hackaton.bankapi.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.padawans.hackaton.bankapi.generated.api.AccountsApi;
import com.padawans.hackaton.bankapi.generated.model.AccountsResponse;
import com.padawans.hackaton.bankapi.generated.model.BalancesResponse;
import com.padawans.hackaton.bankapi.generated.model.TransactionResponse;
import com.padawans.hackaton.bankapi.service.AccountService;

@Controller
@CrossOrigin(origins = "*", methods = { RequestMethod.GET })
public class AccountsController implements AccountsApi {

    @Autowired
    AccountService accountService;

    @Override
    public ResponseEntity<BalancesResponse> accountsAccountIdBalancesGet(String accountId, UUID xRequestId) {
        return accountService.accountsAccountIdBalancesGet(accountId, xRequestId);
    }

    @Override
    public ResponseEntity<TransactionResponse> accountsAccountIdTransactionsGet(String accountId, UUID xRequestId,
            Date dateFrom, Date dateTo, String count, String cursor) {
        return accountService.accountsAccountIdTransactionsGet(accountId, xRequestId, dateFrom, dateTo);
    }

    @Override
    public ResponseEntity<AccountsResponse> accountsGet(UUID xRequestId) {
        return accountService.accountsGet(xRequestId);
    }

}
