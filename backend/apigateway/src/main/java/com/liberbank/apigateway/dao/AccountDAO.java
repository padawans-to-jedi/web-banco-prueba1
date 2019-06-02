package com.liberbank.apigateway.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class AccountDAO {

	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
	private UserDAO user;
	
	@Column(unique = true)
	private String iban;
	
	@Column
	private String currency;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "creditor_id", nullable = false)
	private CreditorAgentDAO agent;

	
	
	public AccountDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountDAO(UserDAO user, String iban, String currency) {
		super();
		this.user = user;
		this.iban = iban;
		this.currency = currency;
	}
	
	
	
}
