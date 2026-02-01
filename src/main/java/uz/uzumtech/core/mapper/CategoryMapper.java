package uz.uzumtech.core.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import uz.uzumtech.core.dto.request.CategoryRequestDto;
import uz.uzumtech.core.dto.response.CategoryResponseDto;
import uz.uzumtech.core.dto.response.PageResponseDto;
import uz.uzumtech.core.entity.Category;

@Mapper(config = GlobalMapperConfig.class)
public interface CategoryMapper {

    CategoryResponseDto toResponse(Category category);

    Category toEntity(CategoryRequestDto request);

    default PageResponseDto<CategoryResponseDto> toPageResponse(Page<Category> page) {
        return new PageResponseDto<>(
                page.getContent().stream().map(this::toResponse).toList(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.getNumber() + 1,
                page.isLast()
        );
    }

}
