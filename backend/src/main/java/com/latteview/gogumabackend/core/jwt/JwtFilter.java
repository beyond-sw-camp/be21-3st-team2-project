package com.latteview.gogumabackend.core.jwt;

import com.latteview.gogumabackend.core.enums.UserRole;
import com.latteview.gogumabackend.user.domain.CustomUserDetails;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

  private final JwtUtil jwtUtil;
  private final StringRedisTemplate stringRedisTemplate;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    // Authorization 헤더에서 Bearer 토큰 추출
    String authorization = request.getHeader("Authorization");

    if (authorization == null || !authorization.startsWith("Bearer ")) {
      filterChain.doFilter(request, response);
      return;
    }

    String accessToken = authorization.substring(7);

    // 블랙리스트 검사
    String blacklistKey = RedisKeyUtil.getBlackListKey(accessToken);
    if (Boolean.TRUE.equals(stringRedisTemplate.hasKey(blacklistKey))) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      response.getWriter().print("blacklisted access token");
      return;
    }

    // 만료 검사
    try {
      jwtUtil.isExpired(accessToken);
    } catch (ExpiredJwtException e) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      response.getWriter().print("access token expired");
      return;
    }

    // access 토큰인지 확인
    if (!"access".equals(jwtUtil.getCategory(accessToken))) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      response.getWriter().print("invalid access token");
      return;
    }

    // 인증 객체 생성
    Long userId = jwtUtil.getUserId(accessToken);
    String email = jwtUtil.getEmail(accessToken);
    String username = jwtUtil.getUsername(accessToken);
    UserRole role = UserRole.valueOf(jwtUtil.getRole(accessToken));

    CustomUserDetails userDetails = new CustomUserDetails(userId, email, username, null, role);

    Authentication authentication =
        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

    // SecurityContext에 인증 정보 저장
    SecurityContextHolder.getContext().setAuthentication(authentication);

    filterChain.doFilter(request, response);
  }
}
