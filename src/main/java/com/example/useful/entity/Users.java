package com.example.useful.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="user")
public class Users {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@NotNull(message = "Name can't be null")
	private String name;
	
	@Size(min = 5, max = 45, message = "Size limit is 5 letters to 45 letters")
	private String description;
	private String userRole;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Company company;
		
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Address> address;
	
		public Users() {
		super();
	}


		public Users(String name, String description, String userRole) {
			
			this.name = name;
			this.description = description;
			this.userRole = userRole;
		}

		

		public Users(@NotNull(message = "Name can't be null") String name,
				@Size(min = 5, max = 45, message = "Size limit is 5 letters to 45 letters") String description,
				String userRole, Company company, List<Address> address) {
			super();
			this.name = name;
			this.description = description;
			this.userRole = userRole;
			this.company = company;
			this.address = address;
		}


		public Company getCompany() {
			return company;
		}


		public void setCompany(Company company) {
			this.company = company;
		}


		public List<Address> getAddress() {
			return address;
		}


		public void setAddress(List<Address> address) {
			this.address = address;
		}


		public Integer getUserId() {
			return userId;
		}


		public void setUserId(Integer userId) {
			this.userId = userId;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public String getUserRole() {
			return userRole;
		}


		public void setUserRole(String userRole) {
			this.userRole = userRole;
		}


		@Override
		public String toString() {
			return "Users [userId=" + userId + ", name=" + name + ", description=" + description + ", userRole="
					+ userRole + "]";
		}
	
	
}
