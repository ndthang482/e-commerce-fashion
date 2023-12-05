package com.product.service;

import com.product.domain.entity.Product;
import com.product.domain.entity.ProductLine;
import com.product.repository.ProductLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class ProductLineService implements IProductLineService{

    private final ProductLineRepository productLineRepository;


    @Override
    public ProductLine findById(Long id) {
        return productLineRepository.findById(id).orElseThrow(()
                -> new NotFoundException("Not found productLine with id "+ id));
    }

    @Override
    public ProductLine findByName(String name) {
        return productLineRepository.findByName(name);
    }

    @Override
    public void deleteById(Long id) {
        Product product = new Product();
        productLineRepository.deleteById(id);
//        productService.deleteByProductLineId(product.getProductLineId());
//        imageService.deleteByProductId(product.getId());
    }


    @Override
    public ProductLine save(ProductLine productLine) {
        return productLineRepository.save(productLine);
    }

    @Override
    public Page<ProductLine> findByNameLike(String name, Pageable pageable) {
        return productLineRepository.findByNameLike(name, pageable);
    }

}
