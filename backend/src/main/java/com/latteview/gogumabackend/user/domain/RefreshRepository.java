package com.latteview.gogumabackend.user.domain;

public interface RefreshRepository {

  void deleteByUsername(String username);

  void save(Refresh refresh);
}
