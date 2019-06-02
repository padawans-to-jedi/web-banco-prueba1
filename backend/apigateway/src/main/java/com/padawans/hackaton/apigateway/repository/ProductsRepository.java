package com.padawans.hackaton.apigateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.padawans.hackaton.apigateway.dao.ProductsDAO;
@Repository
public interface ProductsRepository extends JpaRepository<ProductsDAO, Long>{

}
