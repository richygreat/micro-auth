package com.github.richygreat.microauth.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.richygreat.microauth.model.UserDTO;
import com.github.richygreat.microauth.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController {
	private final UserService userService;

	@PostMapping
	public ResponseEntity<UserDTO> register(@RequestBody @Valid UserDTO userDTO) {
		userService.create(userDTO);
		return ResponseEntity.ok().body(userDTO);
	}
}
