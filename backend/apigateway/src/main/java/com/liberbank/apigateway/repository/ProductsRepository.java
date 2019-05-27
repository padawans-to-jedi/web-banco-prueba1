package com.liberbank.apigateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.liberbank.apigateway.dao.ProductsDAO;
@Repository
public interface ProductsRepository extends JpaRepository<ProductsDAO, Long>{

}
