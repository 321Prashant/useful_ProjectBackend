package com.example.useful.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rolesId;
	
	private String roleType;
	
//	@ManyToMany(mappedBy = "roles")
//	private Users user;
}
