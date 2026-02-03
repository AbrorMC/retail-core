package uz.uzumtech.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.uzumtech.core.entity.Price;

import java.util.Optional;

public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query("""
            SELECT p
            FROM Price p
            WHERE p.food_id = :id
            ORDER BY p.created_at
            LIMIT 1""")
    Optional<Price> getCurrentPriceByFoodId(@Param("id") Long id);
}
