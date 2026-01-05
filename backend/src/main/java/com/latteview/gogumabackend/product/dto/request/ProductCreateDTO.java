package com.latteview.gogumabackend.product.dto.request;

import com.latteview.gogumabackend.product.enums.Category;

public record ProductCreateDTO(String title, String description, Category category, String price) {}
