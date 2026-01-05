package com.latteview.gogumabackend.user.domain;

import com.latteview.gogumabackend.core.domain.BaseEntity;
import com.latteview.gogumabackend.core.enums.UserRole;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String username;
  private String password;
  private String email;

  @Enumerated(EnumType.STRING)
  private UserRole role;

  private Long postCount = 0L;

  @Builder
  private User(String username, String password, String email, UserRole role) {
    this.username = username;
    this.password = password;
    this.email = email;
    this.role = role;
  }

  public static User create(String username, String encodedPassword, String email) {
    return User.builder()
        .username(username)
        .password(encodedPassword)
        .email(email)
        .role(UserRole.ROLE_USER)
        .build();
  }

  public void increasePostCount() {
    this.postCount++;
  }
}
