package com.latteview.gogumabackend.user.domain;

import java.util.Optional;

public interface UserRepository {

  boolean existsByEmail(String email);

  Optional<User> findById(Long id);

  User save(User user);

  Optional<User> findByEmail(String email);
}
