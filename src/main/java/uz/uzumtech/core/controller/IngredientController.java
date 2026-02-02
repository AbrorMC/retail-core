package uz.uzumtech.core.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.uzumtech.core.dto.request.IngredientRequest;
import uz.uzumtech.core.dto.response.IngredientResponse;
import uz.uzumtech.core.service.IngredientService;

@RestController
@RequestMapping("api/core/ingredients")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IngredientController {

    IngredientService ingredientService;

    @PostMapping
    public ResponseEntity<IngredientResponse> create(@RequestBody IngredientRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ingredientService.create(request));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ingredientService.delete(id);
    }
}
