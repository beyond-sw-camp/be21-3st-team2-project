package com.latteview.gogumabackend.user.domain.validator;

import com.latteview.gogumabackend.core.exception.ErrorCode;
import com.latteview.gogumabackend.core.exception.GlobalException;
import com.latteview.gogumabackend.core.jwt.JwtUtil;
import com.latteview.gogumabackend.core.jwt.RedisKeyUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RefreshTokenValidator {

  private final JwtUtil jwtUtil;
  private final StringRedisTemplate redisTemplate;

  public Long validate(String refreshToken) {

    if (jwtUtil.isExpired(refreshToken)) {
      throw new GlobalException(ErrorCode.REFRESH_TOKEN_EXPIRED);
    }

    if (!"refresh".equals(jwtUtil.getCategory(refreshToken))) {
      throw new GlobalException(ErrorCode.TOKEN_CATEGORY_MISMATCH);
    }

    Long userId = jwtUtil.getUserId(refreshToken);

    String saved = redisTemplate.opsForValue().get(RedisKeyUtil.getRefreshTokenKey(userId));

    if (saved == null) {
      throw new GlobalException(ErrorCode.REFRESH_TOKEN_NOT_FOUND);
    }

    if (!saved.equals(refreshToken)) {
      throw new GlobalException(ErrorCode.REFRESH_TOKEN_MISMATCH);
    }

    return userId;
  }
}
