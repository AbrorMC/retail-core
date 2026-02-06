package uz.uzumtech.core.mapper;

import org.mapstruct.*;
import org.springframework.data.domain.Page;
import uz.uzumtech.core.dto.request.FoodRequest;
import uz.uzumtech.core.dto.response.FoodDetailsResponse;
import uz.uzumtech.core.dto.response.FoodResponse;
import uz.uzumtech.core.dto.response.PageResponse;
import uz.uzumtech.core.entity.Food;
import uz.uzumtech.core.entity.Receipt;
import uz.uzumtech.core.entity.ReceiptItem;

import java.math.BigDecimal;

@Mapper(config = GlobalMapperConfig.class, builder = @Builder(disableBuilder = true))
public interface FoodMapper {

    FoodResponse toResponse(Food food);

    @Mapping(target = "category", source = "food.category.name")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "receipt", source = "food.receipt.items")
    FoodDetailsResponse toDetailsResponse(Food food, BigDecimal price);

    @Mapping(target = "ingredient", source = "ingredient.name")
    @Mapping(target = "measure", source = "ingredient.measure")
    FoodDetailsResponse.ReceiptItem toReceiptItemResponse(ReceiptItem item);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "receipt", source = "request")
    Food toEntity(FoodRequest request);

    @Mapping(target = "items", source = "request.receipt")
    @Mapping(target = "food", ignore = true)
    @Mapping(target = "id", ignore = true)
    Receipt toReceipt(FoodRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "receipt", ignore = true)
    @Mapping(target = "ingredient", ignore = true)
    ReceiptItem toReceiptItem(FoodRequest.ReceiptItemRequest request);

    default PageResponse<FoodResponse> toPageResponse(Page<Food> page) {
        return new PageResponse<>(
                page.getContent().stream().map(this::toResponse).toList(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.getNumber() + 1,
                page.isLast()
        );
    }

    @AfterMapping
    default void link(@MappingTarget Food food) {
        Receipt receipt = food.getReceipt();
        if (receipt != null) {
            receipt.setFood(food);
            if (receipt.getItems() != null) {
                receipt.getItems().forEach(item -> item.setReceipt(receipt));
            }
        }
    }
}