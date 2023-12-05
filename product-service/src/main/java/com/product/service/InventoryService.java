package com.product.service;

import com.product.domain.entity.Inventory;
import com.product.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService implements IInventoryService{

    private final InventoryRepository inventoryRepository;
    @Override
    public Inventory findByBranchIdAndProductId(Long branchId, Long productId) {
        return inventoryRepository.findByBranchIdAndProductId(branchId, productId);
    }

    @Override
    public List<Inventory> findAllByProductId(Long productId) {
        return inventoryRepository.findAllByProductId(productId);
    }
}
