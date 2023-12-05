package com.product.repository;

import com.product.domain.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Inventory findByBranchIdAndProductId(Long branchId, Long productId);

    List<Inventory> findAllByProductId(Long productId);
}
