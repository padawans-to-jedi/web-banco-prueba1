package com.padawans.hackaton.apigateway.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agents")
public class CreditorAgentDAO {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true)
	private String name;
	
	
	
}
