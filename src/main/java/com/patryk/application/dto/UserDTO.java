package com.patryk.application.dto;

import javax.validation.constraints.NotNull;

public class UserDTO {
	@NotNull
	private String mail;
	@NotNull
	private String name;
	@NotNull
	private String last_name;
	@NotNull
	private String password;
}
