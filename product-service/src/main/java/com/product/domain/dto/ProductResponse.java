package com.product.domain.dto;

import com.product.domain.entity.Image;
import com.product.domain.entity.ProductLine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private Long id;

    private String name;

    private String color;

    private String size;

    private Long price;

    private String image;

    private LocalDateTime createdAt;
}
