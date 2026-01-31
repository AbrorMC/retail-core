package uz.uzumtech.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.uzumtech.core.entity.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {
}
