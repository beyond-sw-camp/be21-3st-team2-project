package com.latteview.gogumabackend.user.domain.factory;

import com.latteview.gogumabackend.user.domain.Refresh;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class RefreshFactory {

  public Refresh create(String email, String token) {
    return Refresh.create(email, token, LocalDateTime.now().plusDays(1));
  }
}
