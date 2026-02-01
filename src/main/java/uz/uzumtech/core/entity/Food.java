package uz.uzumtech.core.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "foods")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Food extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "Название блюда не может быть пустым!")
    @Column(nullable = false)
    String name;

    @NotNull
    @Positive(message = "Цена должна быть больше 0!")
    @Column(nullable = false)
    BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id")
    Category category;

    @ElementCollection
    @CollectionTable(name = "food_receipt_items", joinColumns = @JoinColumn(name = "food_id"))
    List<ReceiptItem> receipt = new ArrayList<>();
}
