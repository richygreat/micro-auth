package com.github.richygreat.microauth.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserDTO {
    private String userId;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private String roles;
}
