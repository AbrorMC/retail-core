package uz.uzumtech.core.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.uzumtech.core.dto.FoodDto;
import uz.uzumtech.core.dto.response.PageResponseDto;
import uz.uzumtech.core.entity.Food;
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
    public PageResponseDto<FoodDto> getFoodsByCategoryId(Long id, Pageable request) {
        Page<Food> page = foodRepository.findAllByCategoryId(id, request);

        return foodMapper.toResponse(page);
    }

}
