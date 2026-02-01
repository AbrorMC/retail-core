package uz.uzumtech.core.dto.request;

import java.util.List;

public record FoodRequest(
        String name,
        String price,
        Long categoryId,
        List<ReceiptItemRequest> receipt
) {
}
