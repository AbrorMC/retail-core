package uz.uzumtech.core.service;

import org.springframework.data.domain.Pageable;
import uz.uzumtech.core.dto.request.CategoryRequest;
import uz.uzumtech.core.dto.response.CategoryResponse;
import uz.uzumtech.core.dto.response.PageResponse;

public interface CategoryService {

    PageResponse<CategoryResponse> getAll(Pageable request);
    CategoryResponse create(CategoryRequest request);
    void delete(Long id);

}
