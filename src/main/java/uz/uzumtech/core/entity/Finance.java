package uz.uzumtech.core.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "finances")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Finance extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @Column(nullable = false, precision = 19, scale = 2)
    BigDecimal revenue;

    @NotNull
    @Column(nullable = false, precision = 19, scale = 2)
    BigDecimal cost;
}
