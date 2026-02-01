package uz.uzumtech.core.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import uz.uzumtech.core.dto.FoodDto;
import uz.uzumtech.core.dto.response.PageResponseDto;
import uz.uzumtech.core.entity.Food;

@Mapper(config = GlobalMapperConfig.class)
public interface FoodMapper {

    FoodDto toDto(Food food);

    default PageResponseDto<FoodDto> toResponse(Page<Food> page) {
        return new PageResponseDto<>(
                page.getContent().stream().map(this::toDto).toList(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.getNumber() + 1,
                page.isLast()
        );
    }

}
