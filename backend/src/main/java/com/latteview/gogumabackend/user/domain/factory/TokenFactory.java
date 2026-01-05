package com.latteview.gogumabackend.user.domain.factory;

import com.latteview.gogumabackend.core.jwt.JwtUtil;
import com.latteview.gogumabackend.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenFactory {

  private final JwtUtil jwtUtil;

  public String createAccess(User user) {
    return jwtUtil.createJwt(
        "access",
        user.getId(),
        user.getEmail(),
        user.getUsername(),
        user.getRole().name(),
        1000L * 60 * 30);
  }

  public String createRefresh(User user) {
    return jwtUtil.createJwt(
        "refresh",
        user.getId(),
        user.getEmail(),
        user.getUsername(),
        user.getRole().name(),
        1000L * 60 * 60 * 24);
  }
}
