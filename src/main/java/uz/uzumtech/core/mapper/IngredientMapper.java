package uz.uzumtech.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.uzumtech.core.dto.request.IngredientRequest;
import uz.uzumtech.core.dto.response.IngredientResponse;
import uz.uzumtech.core.entity.Ingredient;

@Mapper(config = GlobalMapperConfig.class)
public interface IngredientMapper {

    Ingredient toEntity(IngredientRequest request);
    IngredientResponse toResponse(Ingredient ingredient);

}
