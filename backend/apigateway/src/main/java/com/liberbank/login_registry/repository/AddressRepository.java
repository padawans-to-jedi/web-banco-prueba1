package com.liberbank.login_registry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.liberbank.login_registry.dao.AddressDAO;

@Repository
public interface AddressRepository extends JpaRepository<AddressDAO, Long>{

}
