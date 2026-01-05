package com.latteview.gogumabackend.product.repository;

import com.latteview.gogumabackend.product.domain.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
  Optional<Product> findByTitle(String title);

  List<Product> findAllByTitleContaining(String title);

  List<Product> findTop20ByOrderByIdDesc();
}
