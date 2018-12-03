package com.patryk.application.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userID;
	private String mail;
	private String name;
	private String last_name;
	private String password;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "roleID", nullable = false)
	private Role role;


	public int getUser_id() {
		return userID;
	}

	public void setUser_id(int user_id) {
		this.userID = user_id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {

	}

	public User(String mail, String name, String last_name, String password) {
		super();
		this.mail = mail;
		this.name = name;
		this.last_name = last_name;
		this.password = password;

	}

	public void setRole(Role role) {
		this.role = role;

	}

}
