package com.mohamed.ecommerce.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(  Integer id,
      @NotNull(message = "Product name is required")
      String name,
      @NotNull(message = "description is required")
      String description,
      @Positive(message = "available_quantity should be positive")
      double available_quantity,
      @Positive(message = "price should be positive")
      BigDecimal price,
      @NotNull(message = "price cateogry is required")
      Integer categoryId
 ) {

}
