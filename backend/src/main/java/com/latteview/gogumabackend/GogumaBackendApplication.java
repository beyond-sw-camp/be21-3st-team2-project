package com.latteview.gogumabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GogumaBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(GogumaBackendApplication.class, args);
  }
}
