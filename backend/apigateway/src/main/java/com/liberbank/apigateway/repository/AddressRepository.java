package com.liberbank.apigateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.liberbank.apigateway.dao.AddressDAO;

@Repository
public interface AddressRepository extends JpaRepository<AddressDAO, Long>{

}
