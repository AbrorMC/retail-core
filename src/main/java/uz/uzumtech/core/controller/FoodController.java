package uz.uzumtech.core.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.uzumtech.core.dto.FoodDto;
import uz.uzumtech.core.dto.response.PageResponseDto;
import uz.uzumtech.core.service.FoodService;

@RestController
@RequestMapping("api/core/foods")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FoodController {

    FoodService foodService;

    @GetMapping("/categories/{id}")
    public ResponseEntity<PageResponseDto<FoodDto>> getFoodsByCategoryId(@PathVariable Long id, Pageable pageable) {
        return ResponseEntity.ok(foodService.getFoodsByCategoryId(id, pageable));
    }

}
