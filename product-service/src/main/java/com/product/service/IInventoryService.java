package com.product.service;

import com.product.domain.entity.Inventory;

import java.util.List;

public interface IInventoryService {
    Inventory findByBranchIdAndProductId(Long branchId, Long productId);
    List<Inventory> findAllByProductId(Long productId);
}
