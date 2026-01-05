package com.latteview.gogumabackend.core.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

  @NotBlank(message = "이메일을 반드시 입력해주세요.")
  private String email;

  @NotBlank(message = "비밀번호를 반드시 입력해주세요.")
  private String password;
}
