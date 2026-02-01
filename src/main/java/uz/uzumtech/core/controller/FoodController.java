package uz.uzumtech.core.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.uzumtech.core.dto.request.FoodRequest;
import uz.uzumtech.core.dto.response.FoodDetailsResponse;
import uz.uzumtech.core.dto.response.FoodResponse;
import uz.uzumtech.core.dto.response.PageResponse;
import uz.uzumtech.core.service.FoodService;

@RestController
@RequestMapping("api/core/foods")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FoodController {

    FoodService foodService;

    @GetMapping("/categories/{id}")
    public ResponseEntity<PageResponse<FoodResponse>> getFoodsByCategoryId(@PathVariable Long id, Pageable pageable) {
        return ResponseEntity.ok(foodService.getByCategoryId(id, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodDetailsResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(foodService.get(id));
    }

    @PostMapping
    public ResponseEntity<FoodDetailsResponse> create(@RequestBody FoodRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(foodService.create(request));
    }

}
