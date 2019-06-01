package com.liberbank.apigateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.liberbank.apigateway.dao.AccountDAO;

@Repository
public interface AccountRepository extends JpaRepository<AccountDAO, Long>{

}
