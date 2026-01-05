package com.latteview.gogumabackend.user.domain;

import com.latteview.gogumabackend.core.dto.request.LoginRequest;
import com.latteview.gogumabackend.core.dto.response.LoginResponse;
import com.latteview.gogumabackend.core.dto.response.LogoutResponse;
import com.latteview.gogumabackend.core.dto.response.ReissueResponse;
import com.latteview.gogumabackend.core.jwt.RedisKeyUtil;
import com.latteview.gogumabackend.user.domain.blacklistStore.TokenBlacklistStore;
import com.latteview.gogumabackend.user.domain.extractor.TokenExtractor;
import com.latteview.gogumabackend.user.domain.factory.RefreshFactory;
import com.latteview.gogumabackend.user.domain.factory.TokenFactory;
import com.latteview.gogumabackend.user.domain.reader.UserReader;
import com.latteview.gogumabackend.user.domain.validator.LoginValidator;
import com.latteview.gogumabackend.user.domain.validator.RefreshTokenValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final LoginValidator loginValidator;
  private final RefreshTokenValidator refreshTokenValidator;
  private final TokenExtractor tokenExtractor;
  private final TokenFactory tokenFactory;
  private final RefreshFactory refreshFactory;
  private final StringRedisTemplate redisTemplate;
  private final RefreshRepository refreshRepository;
  private final UserReader userReader;
  private final TokenBlacklistStore tokenBlacklistStore;

  /*
   * 로그인
   * */
  @Transactional
  public LoginResponse login(LoginRequest request) {

    User user = loginValidator.validate(request.getEmail(), request.getPassword());

    String access = tokenFactory.createAccess(user);
    String refresh = tokenFactory.createRefresh(user);

    redisTemplate
        .opsForValue()
        .set(RedisKeyUtil.getRefreshTokenKey(user.getId()), refresh, 1, TimeUnit.DAYS);

    refreshRepository.deleteByUsername(user.getEmail());
    refreshRepository.save(refreshFactory.create(user.getEmail(), refresh));

    return LoginResponse.builder()
        .accessToken(access)
        .refreshToken(refresh)
        .username(user.getUsername())
        .build();
  }

  /*
   * 재발급
   * */
  @Transactional(readOnly = true)
  public ReissueResponse reissue(HttpServletRequest request) {

    String refreshToken = tokenExtractor.extractRefreshToken(request);
    Long userId = refreshTokenValidator.validate(refreshToken);

    User user = userReader.getById(userId);

    String newAccess = tokenFactory.createAccess(user);

    return ReissueResponse.builder().accessToken(newAccess).build();
  }

  /*
   * 로그아웃
   * */
  @Transactional
  public LogoutResponse logout(HttpServletRequest request, HttpServletResponse response) {

    String accessToken = tokenExtractor.extractAccessToken(request);

    tokenBlacklistStore.blacklist(accessToken);

    ResponseCookie delete =
        ResponseCookie.from("refresh", "").path("/").maxAge(0).httpOnly(true).build();

    response.addHeader(HttpHeaders.SET_COOKIE, delete.toString());

    return LogoutResponse.builder().blacklisted(true).refreshDeleted(true).build();
  }
}
