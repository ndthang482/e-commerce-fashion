package com.product.repository;

import com.product.domain.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    Page<Product> findByProductLineIdIn(List<Long> productLineIds, Pageable pageable);

    Page<Product> findByColorAndSizeAndPriceBetween(String color, String memory, Long priceFrom, Long priceTo, Pageable pageable);

    Page<Product> findBySizeAndPriceBetween(String memory, Long priceFrom, Long priceTo, Pageable pageable);

    Page<Product> findByColorAndPriceBetween(String color, Long priceFrom, Long priceTo, Pageable pageable);

}
