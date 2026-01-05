package com.latteview.gogumabackend.user.infrastructure;

import com.latteview.gogumabackend.user.domain.Refresh;
import com.latteview.gogumabackend.user.domain.RefreshRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RefreshRepositoryImpl implements RefreshRepository {

  private final RefreshJpaRepository jpaRepository;

  @Override
  public void deleteByUsername(String username) {
    jpaRepository.deleteByUsername(username);
  }

  @Override
  public void save(Refresh refresh) {
    jpaRepository.save(refresh);
  }
}
