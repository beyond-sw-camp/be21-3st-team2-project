package com.latteview.gogumabackend.product.dto.response;

public record ProductResponseDTO(
    Long id,
    String title,
    String description,
    String username,
    String price,
    String url,
    String category) {}
