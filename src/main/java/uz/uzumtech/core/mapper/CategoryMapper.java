package uz.uzumtech.core.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import uz.uzumtech.core.dto.request.CategoryRequest;
import uz.uzumtech.core.dto.response.CategoryResponse;
import uz.uzumtech.core.dto.response.PageResponse;
import uz.uzumtech.core.entity.Category;

@Mapper(config = GlobalMapperConfig.class)
public interface CategoryMapper {

    CategoryResponse toResponse(Category category);

    Category toEntity(CategoryRequest request);

    default PageResponse<CategoryResponse> toPageResponse(Page<Category> page) {
        return new PageResponse<>(
                page.getContent().stream().map(this::toResponse).toList(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.getNumber() + 1,
                page.isLast()
        );
    }

}
