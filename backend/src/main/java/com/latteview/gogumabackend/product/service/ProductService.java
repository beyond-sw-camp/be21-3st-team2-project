package com.latteview.gogumabackend.product.service;

import com.latteview.gogumabackend.product.domain.Product;
import com.latteview.gogumabackend.product.domain.ProductImage;
import com.latteview.gogumabackend.product.dto.request.ProductCreateDTO;
import com.latteview.gogumabackend.product.dto.response.ProductResponseDTO;
import com.latteview.gogumabackend.product.mapper.ImageMapper;
import com.latteview.gogumabackend.product.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

  private final ProductRepository productRepository;
  private final ImageService imageService;
  private final ImageMapper mapper;

  @Transactional
  public ProductResponseDTO createProduct(
      ProductCreateDTO dto, Long userId, String userName, MultipartFile file) {
    Product product = Product.from(dto, userId, userName);
    Product result = productRepository.save(product);
    ProductImage image = imageService.createImage(file, result.getId());
    return mapper.responseProductMapperDTO(result, image);
  }

  public ProductResponseDTO findByProductId(Long productId) {
    Product product =
        productRepository.findById(productId).orElseThrow(() -> new RuntimeException("상품이 없습니다."));
    ProductImage image = imageService.getImage(productId);
    return mapper.responseProductMapperDTO(product, image);
  }

  public List<ProductResponseDTO> findAllByTitle(String title) {

    List<Product> productList = productRepository.findAllByTitleContaining(title);

    List<Long> productIdList = productList.stream().map(Product::getId).toList();

    List<ProductImage> imageList = imageService.getAllImages(productIdList);

    return mapper.responseProductMapperDTO(productList, imageList);
  }

  public List<ProductResponseDTO> findTop20ByOrderByIdDesc() {
    List<Product> productList = productRepository.findTop20ByOrderByIdDesc();
    List<Long> productIdList = productList.stream().map(Product::getId).toList();
    List<ProductImage> imageList = imageService.getAllImages(productIdList);
    return mapper.responseProductMapperDTO(productList, imageList);
  }
}
