package uz.uzumtech.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import uz.uzumtech.core.dto.request.FoodRequest;
import uz.uzumtech.core.dto.request.ReceiptItemRequest;
import uz.uzumtech.core.dto.response.FoodDetailsResponse;
import uz.uzumtech.core.dto.response.FoodResponse;
import uz.uzumtech.core.dto.response.PageResponse;
import uz.uzumtech.core.entity.Food;
import uz.uzumtech.core.entity.ReceiptItem;

@Mapper(config = GlobalMapperConfig.class)
public interface FoodMapper {

    FoodResponse toResponse(Food food);

    @Mapping(target = "category", source = "category.name")
    FoodDetailsResponse toDetailsResponse(Food food);

    @Mapping(target = "ingredient", source = "ingredient.name")
    FoodDetailsResponse.ReceiptItem toReceiptDto(ReceiptItem item);

    @Mapping(target = "category", ignore = true)
    Food toEntity(FoodRequest request);

    @Mapping(target = "ingredient", ignore = true)
    ReceiptItem toReceiptItem(ReceiptItemRequest request);

    default PageResponse<FoodResponse> toPageResponse(Page<Food> page) {
        return new PageResponse<>(
                page.getContent().stream().map(this::toResponse).toList(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.getNumber() + 1,
                page.isLast()
        );
    }

}
