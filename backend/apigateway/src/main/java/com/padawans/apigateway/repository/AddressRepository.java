package com.padawans.apigateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.padawans.apigateway.dao.AddressDAO;

@Repository
public interface AddressRepository extends JpaRepository<AddressDAO, Long>{

}
