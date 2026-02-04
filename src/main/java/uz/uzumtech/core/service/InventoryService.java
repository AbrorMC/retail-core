package uz.uzumtech.core.service;

import uz.uzumtech.core.dto.request.InventoryRequest;
import uz.uzumtech.core.dto.response.InventoryResponse;

public interface InventoryService {
    InventoryResponse increaseStock(InventoryRequest request);
}
