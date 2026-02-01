package uz.uzumtech.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.uzumtech.core.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {


}
