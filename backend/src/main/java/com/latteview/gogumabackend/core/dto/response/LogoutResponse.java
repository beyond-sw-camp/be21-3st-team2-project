package com.latteview.gogumabackend.core.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LogoutResponse {

  private boolean blacklisted;

  private boolean refreshDeleted;
}
