package uz.uzumtech.core.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.uzumtech.core.dto.request.InventoryRequest;
import uz.uzumtech.core.dto.response.InventoryResponse;
import uz.uzumtech.core.service.InventoryService;

@RestController
@RequestMapping("api/core/inventory")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InventoryController {

    InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<InventoryResponse> increase(@RequestBody InventoryRequest request) {
        return ResponseEntity.ok(inventoryService.increaseStock(request));
    }
}
