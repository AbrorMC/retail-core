package uz.uzumtech.core.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.uzumtech.core.dto.request.FoodRequest;
import uz.uzumtech.core.dto.response.FoodDetailsResponse;
import uz.uzumtech.core.dto.response.FoodResponse;
import uz.uzumtech.core.dto.response.PageResponse;
import uz.uzumtech.core.entity.Food;
import uz.uzumtech.core.exception.FoodNotFoundException;
import uz.uzumtech.core.mapper.FoodMapper;
import uz.uzumtech.core.repository.FoodRepository;
import uz.uzumtech.core.service.FoodService;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FoodServiceImpl implements FoodService {

    FoodMapper foodMapper;
    FoodRepository foodRepository;

    @Override
    @Transactional(readOnly = true)
    public PageResponse<FoodResponse> getByCategoryId(Long id, Pageable request) {
        Page<Food> page = foodRepository.findAllByCategoryId(id, request);

        return foodMapper.toPageResponse(page);
    }

    @Override
    @Transactional(readOnly = true)
    public FoodDetailsResponse get(Long id) {
        var food = foodRepository
                .findById(id)
                .orElseThrow(() -> new FoodNotFoundException(id.toString()));

        return foodMapper.toDetailsResponse(food);
    }

    @Override
    public FoodDetailsResponse create(FoodRequest request) {
        //TODO: implement later
        return null;
    }

}
