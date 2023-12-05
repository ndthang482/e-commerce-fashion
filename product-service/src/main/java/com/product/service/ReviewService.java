package com.product.service;

import com.product.domain.entity.Review;
import com.product.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class ReviewService implements IReviewService{
    private final ReviewRepository reviewRepository;

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id).orElseThrow(()
                -> new NotFoundException("Not found review with id "+ id));
    }

    @Override
    public Review findByProductId(Long productId) {
        return reviewRepository.findByProductId(productId);
    }
}
