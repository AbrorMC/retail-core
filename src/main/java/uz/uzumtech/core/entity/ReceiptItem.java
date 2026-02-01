package uz.uzumtech.core.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import uz.uzumtech.core.constant.enums.UnitOfMeasure;

import java.math.BigDecimal;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReceiptItem {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")
    Ingredient ingredient;

    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    UnitOfMeasure measure;

    BigDecimal quantity;
}
