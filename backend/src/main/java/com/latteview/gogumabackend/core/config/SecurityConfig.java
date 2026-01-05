package com.latteview.gogumabackend.core.config;

import com.latteview.gogumabackend.core.jwt.JwtFilter;
import com.latteview.gogumabackend.core.jwt.JwtUtil;
import com.latteview.gogumabackend.user.domain.RefreshRepository;
import com.latteview.gogumabackend.user.domain.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  private final AuthenticationConfiguration authenticationConfiguration;
  private final JwtUtil jwtUtil;
  private final UserRepository userRepository;
  private final RefreshRepository refreshRepository;
  private final StringRedisTemplate stringRedisTemplate;

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)
      throws Exception {

    return configuration.getAuthenticationManager();
  }

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {

    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http.cors(
        corsCustomizer ->
            corsCustomizer.configurationSource(
                new CorsConfigurationSource() {

                  @Override
                  public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {

                    CorsConfiguration configuration = new CorsConfiguration();

                    configuration.setAllowedOriginPatterns(Collections.singletonList("*"));
                    configuration.setAllowedMethods(Collections.singletonList("*"));
                    configuration.setAllowCredentials(true);
                    configuration.setAllowedHeaders(Collections.singletonList("*"));
                    configuration.setMaxAge(3600L);

                    configuration.setExposedHeaders(Collections.singletonList("Set-Cookie"));
                    configuration.setExposedHeaders(Collections.singletonList("access"));

                    return configuration;
                  }
                }));

    // csrf disable
    http.csrf((auth) -> auth.disable());

    // From 로그인 방식 disable
    http.formLogin((auth) -> auth.disable());

    // http basic 인증 방식 disable
    http.httpBasic((auth) -> auth.disable());

    http.authorizeHttpRequests(
        auth ->
            auth.requestMatchers(
                    "/api/v1/user/register",
                    "/api/v1/auth/login",
                    "/api/v1/auth/logout",
                    "/api/v1/auth/reissue",
                    "/v3/api-docs/**",
                    "/swagger-ui/**",
                    "/swagger-ui.html")
                .permitAll()
                .requestMatchers("/api/v1/user/me")
                .hasRole("USER")
                .requestMatchers(HttpMethod.POST, "/api/v1/products")
                .authenticated()
                .requestMatchers("/api/v1/products/**")
                .permitAll()
                .anyRequest()
                .authenticated());

    // access 토큰 검증
    http.addFilterBefore(
        new JwtFilter(jwtUtil, stringRedisTemplate), UsernamePasswordAuthenticationFilter.class);

    http.sessionManagement(
        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

    return http.build();
  }
}
