package uz.uzumtech.core.dto.request;

import uz.uzumtech.core.constant.enums.UnitOfMeasure;

import java.math.BigDecimal;

public record ReceiptItemRequest(
        Long ingredientId,
        UnitOfMeasure measure,
        BigDecimal quantity
) {}
