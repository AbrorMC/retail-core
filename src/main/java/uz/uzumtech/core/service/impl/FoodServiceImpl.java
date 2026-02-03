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
import uz.uzumtech.core.entity.Price;
import uz.uzumtech.core.exception.CategoryNotFoundException;
import uz.uzumtech.core.exception.FoodNotFoundException;
import uz.uzumtech.core.mapper.FoodMapper;
import uz.uzumtech.core.repository.CategoryRepository;
import uz.uzumtech.core.repository.FoodRepository;
import uz.uzumtech.core.repository.PriceRepository;
import uz.uzumtech.core.service.FoodService;

import java.math.BigDecimal;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FoodServiceImpl implements FoodService {

    FoodMapper foodMapper;
    FoodRepository foodRepository;
    CategoryRepository categoryRepository;
    PriceRepository priceRepository;

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

        var price = priceRepository
                .getCurrentPriceByFoodId(id)
                .orElseThrow();

        return foodMapper.toDetailsResponse(food, price.getPrice());
    }

    @Override
    @Transactional
    public FoodDetailsResponse create(FoodRequest request) {
        var food = foodMapper.toEntity(request);
        food.setCategory(categoryRepository
                .findById(request.categoryId())
                .orElseThrow(() -> new CategoryNotFoundException(request.categoryId().toString()))
        );

        var receipt = foodMapper.toReceipt(request);

        IntStream.range(0, receipt.getItems().size()).forEach(i -> {
            var itemRequest = request.receipt().get(i);
            var item = foodMapper.toReceiptItem(itemRequest);
            receipt.addItem(item);
        });

        food.setReceipt(receipt);

        var savedFood = foodRepository.save(food);
        var price = createPrice(savedFood, request.price());

        return foodMapper.toDetailsResponse(savedFood, price.getPrice());
    }

    @Transactional
    public Price createPrice(Food food, BigDecimal price) {
        var priceObj = new Price();
        priceObj.setFood(food);
        priceObj.setPrice(price);

        return priceRepository.save(priceObj);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        var food = foodRepository
                .findById(id)
                .orElseThrow(() -> new FoodNotFoundException(id.toString()));
        food.setActive(false);

        var receipt = food.getReceipt();
        if (receipt != null) {
            receipt.setActive(false);
        }

        var price = priceRepository
                .getCurrentPriceByFoodId(id)
                .orElseThrow();

        price.setActive(false);
    }
}
