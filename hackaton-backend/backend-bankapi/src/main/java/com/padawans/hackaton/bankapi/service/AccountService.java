package com.padawans.hackaton.bankapi.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.padawans.hackaton.bankapi.generated.model.AccountsResponse;
import com.padawans.hackaton.bankapi.generated.model.BalancesResponse;
import com.padawans.hackaton.bankapi.generated.model.TransactionResponse;

public interface AccountService {

    ResponseEntity<AccountsResponse> accountsGet(UUID xRequestId);

    ResponseEntity<TransactionResponse> accountsAccountIdTransactionsGet(String accountId, UUID xRequestId,
            Date dateFrom, Date dateTo);

    ResponseEntity<BalancesResponse> accountsAccountIdBalancesGet(String accountId, UUID xRequestId);

}
