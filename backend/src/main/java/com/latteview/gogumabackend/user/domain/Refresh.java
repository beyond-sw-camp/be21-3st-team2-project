package com.latteview.gogumabackend.user.domain;

import com.latteview.gogumabackend.core.domain.BaseEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "refresh")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Refresh extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String username;

  @Column(nullable = false, columnDefinition = "TEXT")
  private String token;

  @Column(nullable = false)
  private LocalDateTime expiredAt;

  public static Refresh create(String username, String token, LocalDateTime expiredAt) {
    Refresh entity = new Refresh();
    entity.username = username;
    entity.token = token;
    entity.expiredAt = expiredAt;
    return entity;
  }
}
