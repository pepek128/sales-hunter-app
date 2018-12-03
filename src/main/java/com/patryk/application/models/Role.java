package com.patryk.application.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roleID;
	private String role_name;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "role")
	private User user;
	
	
	public int getRole_id() {
		return roleID;
	}

	public void setRole_id(int role_id) {
		this.roleID = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public Role() {

	}

	public Role(String role_name) {
		super();
		this.role_name = role_name;
	}

	public void setUser(User user) {
		this.user=user;
		
	}

}
