package com.latteview.gogumabackend.user.controller;

import com.latteview.gogumabackend.core.ApiResponse;
import com.latteview.gogumabackend.core.dto.request.LoginRequest;
import com.latteview.gogumabackend.core.dto.response.LoginResponse;
import com.latteview.gogumabackend.core.dto.response.LogoutResponse;
import com.latteview.gogumabackend.core.dto.response.ReissueResponse;
import com.latteview.gogumabackend.user.domain.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

  private final AuthService authService;

  /*
   *  로그인
   * */
  @PostMapping("/login")
  public ResponseEntity<ApiResponse<LoginResponse>> login(
      @Valid @RequestBody LoginRequest request, HttpServletResponse response) {
    LoginResponse loginResponse = authService.login(request);

    ResponseCookie refreshCookie =
        ResponseCookie.from("refresh", loginResponse.getRefreshToken())
            .httpOnly(true)
            .path("/")
            .maxAge(60 * 60 * 24)
            .sameSite("Lax")
            .build();

    response.addHeader(HttpHeaders.SET_COOKIE, refreshCookie.toString());

    return ResponseEntity.ok(ApiResponse.success(loginResponse));
  }

  /*
   * 로그아웃
   * */
  @PostMapping("/logout")
  public ResponseEntity<ApiResponse<LogoutResponse>> logout(
      HttpServletRequest request, HttpServletResponse response) {
    LogoutResponse result = authService.logout(request, response);
    return ResponseEntity.ok(ApiResponse.success(result));
  }

  /*
   * 재발행
   * */
  @PostMapping("/reissue")
  public ResponseEntity<ApiResponse<ReissueResponse>> reissue(HttpServletRequest request) {
    ReissueResponse response = authService.reissue(request);
    return ResponseEntity.ok(ApiResponse.success(response));
  }
}
