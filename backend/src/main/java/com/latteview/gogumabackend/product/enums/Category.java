package com.latteview.gogumabackend.product.enums;

import lombok.Getter;

@Getter
public enum Category {
  DIGITAL("디지털기기"),
  ELECTRONIC("생활가전"),
  INTERIOR("주방/인테리어"),
  LIFE("생활/주방"),
  ETC("기타");

  private final String message;

  Category(String message) {
    this.message = message;
  }
}
