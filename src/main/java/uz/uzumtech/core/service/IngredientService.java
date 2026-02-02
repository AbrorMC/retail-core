package uz.uzumtech.core.service;

import org.springframework.http.ResponseEntity;
import uz.uzumtech.core.dto.request.IngredientRequest;
import uz.uzumtech.core.dto.response.IngredientResponse;

public interface IngredientService {

    IngredientResponse create(IngredientRequest request);

    void delete(Long id);
}
