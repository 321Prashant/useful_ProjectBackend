package com.example.useful.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Roless {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rolesId;
	
	private String roleType;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
	private Set<Users> user;

	public Roless(String roleType, Set<Users> user) {
		super();
		this.roleType = roleType;
		this.user = user;
	}

	public Roless() {
		super();
	}
	
	
	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public Set<Users> getUser() {
		return user;
	}

	public void setUser(Set<Users> user) {
		this.user = user;
	}


}
