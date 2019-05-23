package com.scs.jwtauthentication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import com.scs.jwtauthentication.message.response.JwtResponse;


public class UserResponse {
	
	
		
		private Long id;

		
		private String name;
		
		
		private String surname;

		
		private String username;

		
		private String phone;

		
		private String email;

		
		private JwtResponse token;


		public UserResponse(Long id, String name, String surname, String username, String phone, String email,
				JwtResponse token) {
			super();
			this.id = id;
			this.name = name;
			this.surname = surname;
			this.username = username;
			this.phone = phone;
			this.email = email;
			this.token = token;
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


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public String getPhone() {
			return phone;
		}


		public void setPhone(String phone) {
			this.phone = phone;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		


		public JwtResponse getToken() {
			return token;
		}


		public void setToken(JwtResponse token) {
			this.token = token;
		}


		@Override
		public String toString() {
			return "UserResponse [id=" + id + ", name=" + name + ", surname=" + surname + ", username=" + username
					+ ", phone=" + phone + ", email=" + email + ", jwtResponse=" + token + "]";
		} 
		
		
}
