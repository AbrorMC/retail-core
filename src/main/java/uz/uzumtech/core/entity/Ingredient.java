package uz.uzumtech.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import uz.uzumtech.core.constant.enums.UnitOfMeasure;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "ingredients")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Ingredient extends BaseEntity {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true)
    String name;

    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(name = "unit_of_measure", nullable = false)
    UnitOfMeasure measure;

    @Column(nullable = false, precision = 19, scale = 2)
    BigDecimal cost;
}
