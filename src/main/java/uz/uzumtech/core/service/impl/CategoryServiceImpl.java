package uz.uzumtech.core.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.uzumtech.core.dto.request.CategoryRequestDto;
import uz.uzumtech.core.dto.response.CategoryResponseDto;
import uz.uzumtech.core.dto.response.PageResponseDto;
import uz.uzumtech.core.entity.Category;
import uz.uzumtech.core.exception.CategoryNotFoundException;
import uz.uzumtech.core.mapper.CategoryMapper;
import uz.uzumtech.core.repository.CategoryRepository;
import uz.uzumtech.core.service.CategoryService;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;

    @Override
    @Transactional(readOnly = true)
    public PageResponseDto<CategoryResponseDto> getAll(Pageable request) {
        Page<Category> page = categoryRepository.findAll(request);

        return categoryMapper.toPageResponse(page);
    }

    @Override
    @Transactional
    public CategoryResponseDto create(CategoryRequestDto request) {
        var category = categoryMapper.toEntity(request);
        var result = categoryRepository.save(category);

        return categoryMapper.toResponse(result);
    }

    @Override
    public void delete(Long id) {
        var category = categoryRepository
                .findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id.toString()));
        category.setActive(false);
    }
}
