package uz.uzumtech.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.uzumtech.core.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
