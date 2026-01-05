package com.latteview.gogumabackend.user.domain.reader;

import com.latteview.gogumabackend.core.exception.ErrorCode;
import com.latteview.gogumabackend.core.exception.GlobalException;
import com.latteview.gogumabackend.user.domain.User;
import com.latteview.gogumabackend.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserReader {

  private final UserRepository userRepository;

  public User getById(Long userId) {
    return userRepository
        .findById(userId)
        .orElseThrow(() -> new GlobalException(ErrorCode.USER_NOT_FOUND));
  }
}
