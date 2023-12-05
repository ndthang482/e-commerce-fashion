package com.product.repository;

import com.product.domain.entity.Product;
import com.product.domain.entity.ProductLine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductLineRepository extends JpaRepository<ProductLine, Long>, JpaSpecificationExecutor<ProductLine> {

    Optional<ProductLine> findById(Long id);

    ProductLine findByName(String name);

    Page<ProductLine> findByNameLike(String name, Pageable pageable);
}
