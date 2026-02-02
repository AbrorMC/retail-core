package uz.uzumtech.core.dto.request;

import uz.uzumtech.core.constant.enums.UnitOfMeasure;

public record IngredientRequest(
        String name,
        UnitOfMeasure measure
) {
}
