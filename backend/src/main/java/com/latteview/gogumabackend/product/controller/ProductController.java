package com.latteview.gogumabackend.product.controller;

import com.latteview.gogumabackend.core.ApiResponse;
import com.latteview.gogumabackend.product.dto.request.ProductCreateDTO;
import com.latteview.gogumabackend.product.dto.response.ProductResponseDTO;
import com.latteview.gogumabackend.product.service.ProductService;
import com.latteview.gogumabackend.user.domain.CustomUserDetails;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
@Slf4j
public class ProductController {

  private final ProductService productService;

  @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<ApiResponse<String>> createProduct(
      @AuthenticationPrincipal CustomUserDetails userDetails,
      @Valid @RequestPart("dto") ProductCreateDTO dto,
      @RequestPart("file") MultipartFile file) {
    log.info("{}", userDetails.getUserId());
    log.info("{}", userDetails.getEmail());
    log.info("{}", userDetails.getUsername());
    log.info("{}", userDetails.getRole());
    productService.createProduct(dto, userDetails.getUserId(), userDetails.getUsername(), file);
    return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("상품이 생성되었습니다."));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ApiResponse<ProductResponseDTO>> getProduct(@PathVariable Long id) {
    return ResponseEntity.ok(ApiResponse.success(productService.findByProductId(id)));
  }

  @GetMapping("/search")
  public ResponseEntity<ApiResponse<List<ProductResponseDTO>>> getAllProductsByTitle(
      @RequestParam String title) {
    List<ProductResponseDTO> result = productService.findAllByTitle(title);
    return ResponseEntity.ok(ApiResponse.success(result));
  }

  @GetMapping()
  public ResponseEntity<ApiResponse<List<ProductResponseDTO>>> getAllProductsRecently() {
    return ResponseEntity.ok(ApiResponse.success(productService.findTop20ByOrderByIdDesc()));
  }
}
