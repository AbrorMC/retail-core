package uz.uzumtech.core.service;

import org.springframework.data.domain.Pageable;
import uz.uzumtech.core.dto.request.CategoryRequestDto;
import uz.uzumtech.core.dto.response.CategoryResponseDto;
import uz.uzumtech.core.dto.response.PageResponseDto;

public interface CategoryService {

    PageResponseDto<CategoryResponseDto> getAll(Pageable request);
    CategoryResponseDto create(CategoryRequestDto request);
    void delete(Long id);

}
