package com.product.service;

import com.product.domain.entity.Image;
import com.product.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService implements IImageService{
    private final ImageRepository imageRepository;


    @Override
    public Image findById(Long id) {
        return imageRepository.findById(id).orElseThrow(()
                -> new NotFoundException("Not found image with id "+ id));

    }

    @Override
    public Image save(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public List<Image> findByProductId(Long productId) {
        return imageRepository.findByProductId(productId);
    }

    @Override
    public void deleteById(Long id) {
        imageRepository.deleteById(id);
    }

}
