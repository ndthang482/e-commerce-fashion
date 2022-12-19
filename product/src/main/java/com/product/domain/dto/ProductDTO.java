package com.product.domain.dto;

import com.product.domain.entity.Image;
import com.product.domain.entity.ProductLine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;

    private ProductLine productLine;

    private String color;

    private String size;

    private Long price;

    private Image image;

    private Long active;

    private LocalDateTime createdAt;
}
