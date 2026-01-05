package com.latteview.gogumabackend.product.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductImage {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String url;

  private String originalFileName;

  private String fileName;

  private Long productId;

  @Builder
  public ProductImage(String url, String originalFileName, String fileName, Long productId) {
    this.url = url;
    this.originalFileName = originalFileName;
    this.fileName = fileName;
    this.productId = productId;
  }
}
