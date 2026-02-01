package uz.uzumtech.core.service;

import org.springframework.data.domain.Pageable;
import uz.uzumtech.core.dto.FoodDto;
import uz.uzumtech.core.dto.response.PageResponseDto;

public interface FoodService {

    PageResponseDto<FoodDto> getFoodsByCategoryId(Long id, Pageable request);

}
