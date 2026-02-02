package uz.uzumtech.core.dto.response;

import uz.uzumtech.core.constant.enums.UnitOfMeasure;

import java.math.BigDecimal;

public record IngredientResponse(
        Long id,
        String name,
        UnitOfMeasure measure,
        BigDecimal cost
) {
}
