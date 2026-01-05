package com.latteview.gogumabackend.core.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {

  @NotBlank(message = "이름을 반드시 입력해주세요.")
  private String username;

  @NotBlank(message = "비밀번호를 반드시 입력해주세요.")
  private String password;

  @NotBlank(message = "이메일을 반드시 입력해주세요.")
  private String email;
}
