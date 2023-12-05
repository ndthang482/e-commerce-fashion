package com.product.service;

import com.product.domain.entity.Product;
import com.product.domain.entity.ProductLine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IProductLineService {
    ProductLine findById(Long id);
    ProductLine findByName(String name);

    void deleteById(Long id);

    ProductLine save(ProductLine productLine);

    Page<ProductLine> findByNameLike(String name, Pageable pageable);
}
