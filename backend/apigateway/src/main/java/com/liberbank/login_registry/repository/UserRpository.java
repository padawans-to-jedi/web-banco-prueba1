package com.liberbank.login_registry.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.liberbank.login_registry.dao.UserDAO;

@Repository
public interface UserRpository extends JpaRepository<UserDAO, Long> {

	Optional<UserDAO> findByUserName(String username);
	Boolean existsByUserName(String username);
 
}
