package uz.uzumtech.core.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "prices")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Price extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "food_id")
    Food food;

    @NotNull
    @Positive(message = "Цена должна быть больше 0!")
    @Column(nullable = false, precision = 19, scale = 2)
    BigDecimal price;

}
