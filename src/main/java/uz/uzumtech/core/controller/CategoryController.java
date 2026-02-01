package uz.uzumtech.core.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.uzumtech.core.dto.response.CategoryResponse;
import uz.uzumtech.core.dto.request.CategoryRequest;
import uz.uzumtech.core.dto.response.PageResponse;
import uz.uzumtech.core.service.CategoryService;

@RestController
@RequestMapping("api/core/categories")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CategoryController {

    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<PageResponse<CategoryResponse>> getAll(Pageable pageable) {
        return ResponseEntity.ok(categoryService.getAll(pageable));
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> create(@RequestBody @Valid CategoryRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryService.create(request));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }
}
