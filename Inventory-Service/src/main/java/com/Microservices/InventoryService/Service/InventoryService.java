package com.Microservices.InventoryService.Service;

import com.Microservices.InventoryService.Dto.InventoryResponse;
import com.Microservices.InventoryService.Repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InventoryService {

        private final InventoryRepository inventoryRepository;


        public List<InventoryResponse> isInStock(List<String> skuCode) {
            return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                    .map(inventory ->
                            InventoryResponse.builder()
                                    .skuCode(inventory.getSkuCode())
                                    .isInStock(inventory.getQuantity() > 0)
                                    .build()
                    ).toList();
        }
    }

