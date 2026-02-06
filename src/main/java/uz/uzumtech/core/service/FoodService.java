package uz.uzumtech.core.service;

import org.springframework.data.domain.Pageable;
import uz.uzumtech.core.dto.request.FoodRequest;
import uz.uzumtech.core.dto.response.FoodDetailsResponse;
import uz.uzumtech.core.dto.response.FoodResponse;
import uz.uzumtech.core.dto.response.PageResponse;

public interface FoodService {

    PageResponse<FoodResponse> getByCategoryId(Long id, Pageable request);
    FoodDetailsResponse get(Long id);

    FoodDetailsResponse create(FoodRequest request);
    void delete(Long id);

}
