package com.patryk.application.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.patryk.application.models.Role;

public class UserDTO {
	@NotNull
	private int id;
	@NotNull
	private String username;
	private Set<Role> roles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public UserDTO() {

	}

	public UserDTO(@NotNull int id, @NotNull String username, Set<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.roles = roles;
	}

}
