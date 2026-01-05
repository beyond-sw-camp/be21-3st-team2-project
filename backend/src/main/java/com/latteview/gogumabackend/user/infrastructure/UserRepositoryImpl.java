package com.latteview.gogumabackend.user.infrastructure;

import com.latteview.gogumabackend.user.domain.User;
import com.latteview.gogumabackend.user.domain.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

  private final UserJpaRepository jpaRepository;

  @Override
  public boolean existsByEmail(String email) {
    return jpaRepository.existsByEmail(email);
  }

  @Override
  public Optional<User> findById(Long id) {
    return jpaRepository.findById(id);
  }

  @Override
  public User save(User user) {
    return jpaRepository.save(user);
  }

  @Override
  public Optional<User> findByEmail(String email) {
    return jpaRepository.findByEmail(email);
  }
}
