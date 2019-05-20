package com.github.richygreat.microauth.service;

import com.github.richygreat.microauth.entity.UserEntity;
import com.github.richygreat.microauth.exception.UserNotFoundException;
import com.github.richygreat.microauth.model.UserDTO;
import com.github.richygreat.microauth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public UserDTO create(UserDTO userDTO) {
        UserEntity user = new UserEntity();
        user.setUserId(UUID.randomUUID().toString());
        user.setUsername(userDTO.getUsername());
        user.setPassword(encoder.encode(userDTO.getPassword()));
        user.setRoles("ROLE_USER");
        convert(userDTO, user);
        userRepository.save(user);
        log.info("Saved user with id: {}", user.getUserId());
        return userDTO;
    }

    public UserDTO get(String id) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException();
        }
        UserDTO userDTO = new UserDTO();
        UserEntity user = optionalUser.get();
        log.info("Found user with id: {}", user.getUserId());
        convert(userDTO, user);
        return userDTO;
    }

    private void convert(UserDTO userDTO, UserEntity user) {
        userDTO.setUsername(user.getUsername());
        userDTO.setUserId(user.getUserId());
        userDTO.setPassword("*****");
        userDTO.setRoles(user.getRoles());
    }

}
