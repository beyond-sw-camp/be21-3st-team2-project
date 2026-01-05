package com.latteview.gogumabackend.product.service;

import com.latteview.gogumabackend.product.domain.ProductImage;
import com.latteview.gogumabackend.product.repository.ImageRepository;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ImageService {

  private final ImageRepository imageRepository;
  private final S3Client s3Client;
  private final String bucket = "goguma";

  @Transactional
  public ProductImage createImage(MultipartFile file, Long productId) {
    String rewriteFileName = UUID.randomUUID().toString() + file.getOriginalFilename();

    try {
      PutObjectRequest request =
          PutObjectRequest.builder()
              .bucket(bucket)
              .key(rewriteFileName)
              .contentType(file.getContentType())
              .build();

      s3Client.putObject(
          request, software.amazon.awssdk.core.sync.RequestBody.fromBytes(file.getBytes()));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return imageRepository.save(
        ProductImage.builder()
            .url(bucket + "/" + rewriteFileName)
            .fileName(file.getOriginalFilename())
            .fileName(rewriteFileName)
            .productId(productId)
            .build());
  }

  public ProductImage getImage(Long productId) {
    return imageRepository
        .findByProductId(productId)
        .orElseThrow(() -> new RuntimeException("이미지가 없습니다."));
  }

  public List<ProductImage> getAllImages(List<Long> productIdList) {
    return imageRepository.findAllByProductIdIn(productIdList);
  }
  ;
}
