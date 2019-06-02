package com.padawans.hackaton.apigateway.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.padawans.hackaton.apigateway.dao.UserDAO;

@Repository
public interface UserRpository extends JpaRepository<UserDAO, Long> {

	Optional<UserDAO> findByUserName(String username);
	Boolean existsByUserName(String username);
 
}
