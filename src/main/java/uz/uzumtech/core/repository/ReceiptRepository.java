package uz.uzumtech.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.uzumtech.core.entity.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
}
