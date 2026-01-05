package com.latteview.gogumabackend.user.domain.blacklistStore;

import com.latteview.gogumabackend.core.jwt.JwtUtil;
import com.latteview.gogumabackend.core.jwt.RedisKeyUtil;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenBlacklistStore {

  private final StringRedisTemplate redisTemplate;
  private final JwtUtil jwtUtil;

  public void blacklist(String accessToken) {
    long ttl = jwtUtil.getRemainingExpiration(accessToken);

    if (ttl <= 0) {
      return;
    }

    redisTemplate
        .opsForValue()
        .set(RedisKeyUtil.getBlackListKey(accessToken), "logout", ttl, TimeUnit.MILLISECONDS);
  }

  public boolean isBlacklisted(String accessToken) {
    return Boolean.TRUE.equals(redisTemplate.hasKey(RedisKeyUtil.getBlackListKey(accessToken)));
  }
}
