package com.latteview.gogumabackend.product.mapper;

import com.latteview.gogumabackend.product.domain.Product;
import com.latteview.gogumabackend.product.domain.ProductImage;
import com.latteview.gogumabackend.product.dto.response.ProductResponseDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ImageMapper {

  @Value("${s3.bucket}")
  String bucket;

  @Value("${s3.endpoint}")
  String endpoint;

  public ProductResponseDTO responseProductMapperDTO(Product product, ProductImage image) {
    return new ProductResponseDTO(
        product.getId(),
        product.getTitle(),
        product.getDescription(),
        product.getUserName(),
        product.getPrice(),
        endpoint + "/" + image.getUrl(),
        product.getCategory().getMessage());
  }

  public List<ProductResponseDTO> responseProductMapperDTO(
      List<Product> productList, List<ProductImage> images) {
    List<ProductResponseDTO> productResponseDTOList = new ArrayList<>();
    Map<Long, ProductImage> imageMap =
        images.stream()
            .collect(
                Collectors.toMap(
                    ProductImage::getProductId, Function.identity(), (oldVal, newVal) -> oldVal));

    for (Product product : productList) {
      ProductImage matchedImage = imageMap.get(product.getId());
      ProductResponseDTO dto = responseProductMapperDTO(product, matchedImage);
      productResponseDTOList.add(dto);
    }

    return productResponseDTOList;
  }
}
