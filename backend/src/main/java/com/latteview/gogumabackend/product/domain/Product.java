package com.latteview.gogumabackend.product.domain;

import com.latteview.gogumabackend.core.domain.BaseEntity;
import com.latteview.gogumabackend.product.dto.request.ProductCreateDTO;
import com.latteview.gogumabackend.product.enums.Category;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Product extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long userId;

  private String title;

  @Column(columnDefinition = "TEXT")
  private String description;

  private String userName;

  private String price;

  @Enumerated(EnumType.STRING)
  private Category category;

  @Builder
  public Product(
      Long userId,
      String title,
      String description,
      String userName,
      Category category,
      String price) {
    this.userId = userId;
    this.title = title;
    this.description = description;
    this.userName = userName;
    this.category = category;
    this.price = price;
  }

  public static Product from(ProductCreateDTO dto, Long userId, String userName) {
    return Product.builder()
        .userId(userId)
        .userName(userName)
        .title(dto.title())
        .description(dto.description())
        .category(dto.category())
        .price(dto.price())
        .build();
  }
}
