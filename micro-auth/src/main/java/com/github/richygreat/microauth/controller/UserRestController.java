package com.github.richygreat.microauth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.richygreat.microauth.model.UserDTO;
import com.github.richygreat.microauth.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserRestController {
	private final UserService userService;

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> read(@PathVariable("id") String id) {
		return ResponseEntity.ok().body(userService.get(id));
	}
}
