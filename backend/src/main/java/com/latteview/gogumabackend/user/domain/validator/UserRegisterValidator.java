package com.latteview.gogumabackend.user.domain.validator;

import com.latteview.gogumabackend.core.exception.ErrorCode;
import com.latteview.gogumabackend.core.exception.GlobalException;
import com.latteview.gogumabackend.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRegisterValidator {

  private final UserRepository userRepository;

  public void validate(String email) {
    if (userRepository.existsByEmail(email)) {
      throw new GlobalException(ErrorCode.USER_ALREADY_EXISTS);
    }
  }
}
