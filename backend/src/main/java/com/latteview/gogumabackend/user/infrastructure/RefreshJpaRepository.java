package com.latteview.gogumabackend.user.infrastructure;

import com.latteview.gogumabackend.user.domain.Refresh;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshJpaRepository extends JpaRepository<Refresh, Long> {

  void deleteByUsername(String username);
}
