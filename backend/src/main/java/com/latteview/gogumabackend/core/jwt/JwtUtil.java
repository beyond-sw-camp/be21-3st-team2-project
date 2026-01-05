package com.latteview.gogumabackend.core.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

  private final SecretKey secretKey;

  // HS256 시크릿 키 생성
  public JwtUtil(@Value("${spring.jwt.secret}") String secret) {
    this.secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
  }

  // Claims 공통 파싱 (구버전 JJWT 방식)
  private Claims parseClaims(String token) {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
  }

  public String getRole(String token) {
    return parseClaims(token).get("role", String.class);
  }

  public String getCategory(String token) {
    return parseClaims(token).get("category", String.class);
  }

  public Long getUserId(String token) {
    return parseClaims(token).get("userId", Long.class);
  }

  public String getEmail(String token) {
    return parseClaims(token).get("email", String.class);
  }

  public String getUsername(String token) {
    return parseClaims(token).get("username", String.class);
  }

  public boolean isExpired(String token) {
    return parseClaims(token).getExpiration().before(new Date());
  }

  public long getRemainingExpiration(String token) {
    Date expiration = parseClaims(token).getExpiration();
    return expiration.getTime() - System.currentTimeMillis();
  }

  public String createJwt(
      String category, Long userId, String email, String username, String role, Long expiredMs) {
    return Jwts.builder()
        .claim("category", category)
        .claim("userId", userId)
        .claim("username", username)
        .claim("email", email)
        .claim("role", role)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + expiredMs))
        .signWith(secretKey)
        .compact();
  }
}
