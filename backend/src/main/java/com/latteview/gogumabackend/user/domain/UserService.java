package com.latteview.gogumabackend.user.domain;

import com.latteview.gogumabackend.core.dto.request.RegisterRequest;
import com.latteview.gogumabackend.user.domain.factory.UserFactory;
import com.latteview.gogumabackend.user.domain.validator.UserRegisterValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final UserRegisterValidator userRegisterValidator;
  private final UserFactory userFactory;

  /*
   * 회원 가입
   * */
  @Transactional
  public void register(RegisterRequest request) {

    // 회원가입 가능 여부 검증
    userRegisterValidator.validate(request.getEmail());

    // User 생성
    User user = userFactory.create(request);

    // 저장
    userRepository.save(user);
  }
}
