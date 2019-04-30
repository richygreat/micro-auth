package com.github.richygreat.microauth.model;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserDTO {
	private String userId;
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	private String roles;
}
