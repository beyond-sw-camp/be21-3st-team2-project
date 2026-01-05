package com.latteview.gogumabackend.user.domain.validator;

import com.latteview.gogumabackend.core.exception.ErrorCode;
import com.latteview.gogumabackend.core.exception.GlobalException;
import com.latteview.gogumabackend.user.domain.User;
import com.latteview.gogumabackend.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginValidator {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public User validate(String email, String rawPassword) {

    User user =
        userRepository
            .findByEmail(email)
            .orElseThrow(() -> new GlobalException(ErrorCode.USER_NOT_FOUND));

    if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
      throw new GlobalException(ErrorCode.PASSWORD_MISMATCH);
    }

    return user;
  }
}
