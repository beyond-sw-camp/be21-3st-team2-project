package com.latteview.gogumabackend.user.domain.factory;

import com.latteview.gogumabackend.core.dto.request.RegisterRequest;
import com.latteview.gogumabackend.core.enums.UserRole;
import com.latteview.gogumabackend.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFactory {

  private final PasswordEncoder passwordEncoder;

  public User create(RegisterRequest request) {
    return User.builder()
        .username(request.getUsername())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(UserRole.ROLE_USER)
        .build();
  }
}
