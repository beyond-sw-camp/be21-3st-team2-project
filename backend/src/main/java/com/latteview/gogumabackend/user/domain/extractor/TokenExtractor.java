package com.latteview.gogumabackend.user.domain.extractor;

import com.latteview.gogumabackend.core.exception.ErrorCode;
import com.latteview.gogumabackend.core.exception.GlobalException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Arrays;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class TokenExtractor {

  public String extractAccessToken(HttpServletRequest request) {
    String header = request.getHeader(HttpHeaders.AUTHORIZATION);
    if (header == null || !header.startsWith("Bearer ")) {
      throw new GlobalException(ErrorCode.AUTHORIZATION_HEADER_MISSING);
    }
    return header.substring(7);
  }

  public String extractRefreshToken(HttpServletRequest request) {
    Cookie[] cookies = request.getCookies();
    if (cookies == null) {
      throw new GlobalException(ErrorCode.REFRESH_TOKEN_NOT_FOUND);
    }

    return Arrays.stream(cookies)
        .filter(c -> "refresh".equals(c.getName()))
        .map(Cookie::getValue)
        .findFirst()
        .orElseThrow(() -> new GlobalException(ErrorCode.REFRESH_TOKEN_NOT_FOUND));
  }
}
