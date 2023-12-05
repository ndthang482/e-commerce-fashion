package com.product.service;

import com.product.domain.entity.Image;

import java.util.List;

public interface IImageService {
    Image findById(Long id);
    Image save(Image image);
    List<Image> findByProductId(Long productId);
    void deleteById(Long id);


}
