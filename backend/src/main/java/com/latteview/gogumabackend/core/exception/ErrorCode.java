package com.latteview.gogumabackend.core.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

  // Common
  INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "C001", "잘못된 입력값입니다."),
  INVALID_TYPE_VALUE(HttpStatus.BAD_REQUEST, "C002", "잘못된 타입입니다."),
  INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "C003", "서버 내부 오류가 발생했습니다."),
  METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "C004", "지원하지 않는 HTTP 메서드입니다."),

  // User
  USER_NOT_FOUND(HttpStatus.NOT_FOUND, "U001", "회원을 찾을 수 없습니다."),
  USER_ALREADY_EXISTS(HttpStatus.CONFLICT, "U002", "이미 존재하는 회원입니다."),
  PASSWORD_MISMATCH(HttpStatus.BAD_REQUEST, "U003", "비밀번호가 일치하지 않습니다."),

  // Token
  AUTHORIZATION_HEADER_MISSING(HttpStatus.UNAUTHORIZED, "A001", "Authorization 헤더가 없습니다."),
  ACCESS_TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "A002", "Access 토큰이 만료되었습니다."),
  INVALID_ACCESS_TOKEN(HttpStatus.UNAUTHORIZED, "A003", "유효하지 않은 Access 토큰입니다."),
  REFRESH_TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "A004", "Refresh 토큰이 만료되었습니다."),
  INVALID_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "A005", "유효하지 않은 Refresh 토큰입니다."),
  REFRESH_TOKEN_NOT_FOUND(HttpStatus.UNAUTHORIZED, "A006", "Refresh 토큰이 존재하지 않습니다."),
  REFRESH_TOKEN_MISMATCH(HttpStatus.UNAUTHORIZED, "A007", "Refresh 토큰이 일치하지 않습니다."),
  TOKEN_CATEGORY_MISMATCH(HttpStatus.UNAUTHORIZED, "A008", "토큰 타입이 올바르지 않습니다."),
  TOKEN_BLACKLISTED(HttpStatus.UNAUTHORIZED, "A009", "로그아웃된 토큰입니다.");

  private final HttpStatus httpStatus;
  private final String code;
  private final String message;
}
