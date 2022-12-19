package com.product.service;

import com.product.domain.entity.Review;

public interface IReviewService {
    Review findById(Long id);
    Review findByProductId(Long productId);
}
