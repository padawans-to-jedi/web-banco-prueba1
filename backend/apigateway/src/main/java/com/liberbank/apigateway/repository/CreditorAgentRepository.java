package com.liberbank.apigateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.liberbank.apigateway.dao.CreditorAgentDAO;

@Repository
public interface CreditorAgentRepository extends JpaRepository<CreditorAgentDAO, Long>{

}
