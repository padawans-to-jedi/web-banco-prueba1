package com.liberbank.apigateway.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;
import java.util.HashSet;



@Entity
@Table(name = "products")
public class ProductsDAO {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany(cascade = {
		    CascadeType.PERSIST,
		    CascadeType.MERGE
		})
		@JoinTable(name = "users_products",
		    joinColumns = @JoinColumn(name = "user_id"),
		    inverseJoinColumns = @JoinColumn(name = "products_id")
		)
		private Set<UserDAO> users = new HashSet<>();
	
	@Column
	private String name;
	
	@Column 
	private String type;
	
	@Column 
	private String tipo;
	
	@Column 
	private Long referenceNumber;

	public Long getId() {
		return id;
	}

	
	
	public ProductsDAO(Long id, Set<UserDAO> users, String name, String type, String tipo, Long referenceNumber) {
		super();
		this.id = id;
		this.users = users;
		this.name = name;
		this.type = type;
		this.tipo = tipo;
		this.referenceNumber = referenceNumber;
	}



	public ProductsDAO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public void setId(Long id) {
		this.id = id;
	}

	public Set<UserDAO> getUsers() {
		return users;
	}

	public void setUsers(Set<UserDAO> users) {
		this.users = users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(Long referenceNumber) {
		this.referenceNumber = referenceNumber;
	}



	@Override
	public String toString() {
		return "ProductsDAO [id=" + id + ", users=" + users + ", name=" + name + ", type=" + type + ", tipo=" + tipo
				+ ", referenceNumber=" + referenceNumber + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((referenceNumber == null) ? 0 : referenceNumber.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductsDAO other = (ProductsDAO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (referenceNumber == null) {
			if (other.referenceNumber != null)
				return false;
		} else if (!referenceNumber.equals(other.referenceNumber))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}
	
	
	
	
}
