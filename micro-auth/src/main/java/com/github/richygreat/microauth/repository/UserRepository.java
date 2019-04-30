package com.github.richygreat.microauth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.richygreat.microauth.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {
	Optional<UserEntity> findByUsername(String username);
}
