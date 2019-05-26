package com.padawans.apigateway.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.padawans.apigateway.dao.UserDAO;

@Repository
public interface UserRpository extends JpaRepository<UserDAO, Long> {

	Optional<UserDAO> findByUserName(String username);

}
