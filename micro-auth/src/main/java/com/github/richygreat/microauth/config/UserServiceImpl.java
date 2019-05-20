package com.github.richygreat.microauth.config;

import com.github.richygreat.microauth.entity.UserEntity;
import com.github.richygreat.microauth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {
    private final BCryptPasswordEncoder encoder;
    private final UserRepository userRepository;
    private final Map<String, User> adminUsers = new HashMap<>();

    @PostConstruct
    public void init() {
        adminUsers.put(SecurityConstants.ROOT_USER,
                new User(SecurityConstants.ROOT_USER, encoder.encode(SecurityConstants.ROOT_USER_TEST_PASSWORD),
                        Collections.singletonList(new SimpleGrantedAuthority(SecurityConstants.ROLE_SUPER_ADMIN))));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User adminUser = adminUsers.get(username);
        if (adminUser != null) {
            return new User(adminUser.getUsername(), adminUser.getPassword(), adminUser.getAuthorities());
        } else {
            Optional<UserEntity> optionalUser = userRepository.findByUsername(username);
            if (!optionalUser.isPresent()) {
                throw new UsernameNotFoundException(username);
            }
            UserEntity user = optionalUser.get();
            return new User(user.getUsername(), user.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority(user.getRoles())));
        }
    }
}
