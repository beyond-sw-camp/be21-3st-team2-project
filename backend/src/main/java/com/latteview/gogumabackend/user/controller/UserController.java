package com.latteview.gogumabackend.user.controller;

import com.latteview.gogumabackend.core.ApiResponse;
import com.latteview.gogumabackend.core.dto.request.RegisterRequest;
import com.latteview.gogumabackend.user.domain.CustomUserDetails;
import com.latteview.gogumabackend.user.domain.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

  private final UserService userService;

  /*
   *  회원가입
   * */
  @PostMapping("/register")
  public ResponseEntity<ApiResponse<Void>> register(@Valid @RequestBody RegisterRequest request) {
    userService.register(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(null));
  }

  /*
   * 테스트
   * */
  @GetMapping("/me")
  public ResponseEntity<ApiResponse<Long>> getMyUserId(
      @AuthenticationPrincipal CustomUserDetails userDetails) {
    return ResponseEntity.ok(ApiResponse.success(userDetails.getUserId()));
  }
}
