package com.latteview.gogumabackend.product.repository;

import com.latteview.gogumabackend.product.domain.ProductImage;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ProductImage, Long> {
  Optional<ProductImage> findByProductId(Long productId);

  List<ProductImage> findAllByProductIdIn(List<Long> productIds);
}
