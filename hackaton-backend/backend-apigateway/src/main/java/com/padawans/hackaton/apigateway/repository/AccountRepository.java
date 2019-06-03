package com.padawans.hackaton.apigateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.padawans.hackaton.apigateway.dao.AccountDAO;

@Repository
public interface AccountRepository extends JpaRepository<AccountDAO, Long>{

}
