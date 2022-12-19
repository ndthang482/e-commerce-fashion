package com.product.service;

import com.product.domain.dto.ProductDTO;
import com.product.domain.dto.ProductDetailOutput;
import com.product.domain.dto.ProductResponse;
import com.product.domain.entity.Product;
import com.product.domain.entity.ProductLine;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public interface IProductService {
    Product save(Product product);
    void createProduct(Product product);
    void createProductDetail(ProductDetailOutput productDetailOutput);
    void updateProductDetail(Long id, ProductDetailOutput productDetailOutput);
    void deleteByProductDetailId(Long id);
    void deleteById(Long id);

    void updateProduct(Long id, Product product);
    PageImpl<?> findAll(String name,String color, String size, Long priceFrom, Long priceTo, int pageNo, int pageSize, String sortBy, String sortDir);
    ProductDetailOutput findByProductDetail(Long id);


}
