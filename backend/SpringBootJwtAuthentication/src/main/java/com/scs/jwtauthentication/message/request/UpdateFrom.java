package com.scs.jwtauthentication.message.request;

import java.util.Set;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UpdateFrom {
	
	  @NotBlank
	    @Size(min = 3, max = 50)
	    private String name;
	    
	    @NotBlank
	    @Size(min = 3, max = 50)
	    private String surname;

	    
	    
	    @NotBlank
	    @Size(min = 3, max = 50)
	    private String phone;

	    
	    private Set<String> role;


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


		public Set<String> getRole() {
			return role;
		}


		public void setRole(Set<String> role) {
			this.role = role;
		}

	
	    


}
