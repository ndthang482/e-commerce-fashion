package com.product.repository;

import com.product.domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> , JpaSpecificationExecutor<Image> {
    Optional<Image> findById(Long id);

    List<Image> findByProductId(Long productId);


    void deleteByProductId(Long productId);
}
