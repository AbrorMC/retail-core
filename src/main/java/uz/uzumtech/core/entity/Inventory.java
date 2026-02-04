package uz.uzumtech.core.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import uz.uzumtech.core.constant.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "inventories")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Inventory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ingredient_id")
    Ingredient ingredient;

    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(nullable = false)
    TransactionType transactionType;

    @Column(nullable = false, precision = 19, scale = 2)
    BigDecimal quantity;

    @Column(nullable = false, precision = 19, scale = 2)
    BigDecimal stock;

    @Column(nullable = false)
    LocalDateTime transactionDate;

    @PrePersist
    protected void onCreate() {
        if (this.transactionDate == null) {
            this.transactionDate = LocalDateTime.now();
        }
    }
}
