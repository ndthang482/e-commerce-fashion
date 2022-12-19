package com.product.domain.dto;

import com.product.domain.entity.Image;
import com.product.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetailOutput {
    private Long id;
    private String name;
    private String color;
    private String size;
    private Long price;
    private List<Image> images;
    private Review review;
    private LocalDateTime createdAt;
}
