package com.liberbank.apigateway.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserDAO {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private String phone;
	
	@Column(unique = true)
	private String userName;
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "user")
	private AddressDAO address;
	
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "user")
	private Set<AccountDAO> accounts = new HashSet<>();
	
	public UserDAO() {}

	
	
	public UserDAO(String name, String surname, String phone, String userName, AddressDAO address,
			Set<AccountDAO> accounts) {
		super();
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.userName = userName;
		this.address = address;
		this.accounts = accounts;
	}



	public UserDAO(String name, String surname, String phone, String userName, AddressDAO address, String password
			) {
		super();
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.userName = userName;
		this.address = address;
		this.password = password;
		
	}



	public UserDAO(Long id, String name, String surname, String phone, String userName, AddressDAO address,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.userName = userName;
		this.address = address;
		this.password = password;
		
	}

	public UserDAO(Long id, String name, String surname, String phone, String userName, AddressDAO address) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.userName = userName;
		this.address = address;

	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public AddressDAO getAddress() {
		return address;
	}



	public void setAddress(AddressDAO address) {
		this.address = address;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Set<AccountDAO> getAccounts() {
		return accounts;
	}



	public void setAccounts(Set<AccountDAO> accounts) {
		this.accounts = accounts;
	}



	@Override
	public String toString() {
		return "UserDAO [id=" + id + ", name=" + name + ", surname=" + surname + ", phone=" + phone + ", userName="
				+ userName + ", address=" + address + ", accounts=" + accounts + "]";
	}
	
	
	

}