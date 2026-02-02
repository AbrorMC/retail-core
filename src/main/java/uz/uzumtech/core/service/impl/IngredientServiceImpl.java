package uz.uzumtech.core.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.uzumtech.core.dto.request.IngredientRequest;
import uz.uzumtech.core.dto.response.IngredientResponse;
import uz.uzumtech.core.exception.IngredientNotFoundException;
import uz.uzumtech.core.mapper.IngredientMapper;
import uz.uzumtech.core.repository.IngredientRepository;
import uz.uzumtech.core.service.IngredientService;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IngredientServiceImpl implements IngredientService {

    IngredientRepository ingredientRepository;
    IngredientMapper ingredientMapper;

    @Override
    @Transactional
    public IngredientResponse create(IngredientRequest request) {
        var ingredient = ingredientMapper.toEntity(request);

        return ingredientMapper.toResponse(ingredientRepository.save(ingredient));
    }

    @Override
    public void delete(Long id) {
        var entity = ingredientRepository
                .findById(id)
                .orElseThrow(() -> new IngredientNotFoundException(id.toString()));

        entity.setActive(false);
    }
}
