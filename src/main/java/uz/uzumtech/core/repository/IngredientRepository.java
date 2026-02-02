package uz.uzumtech.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.uzumtech.core.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
