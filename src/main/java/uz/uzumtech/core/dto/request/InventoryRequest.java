package uz.uzumtech.core.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import uz.uzumtech.core.constant.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record InventoryRequest(

        @NotNull
        @JsonProperty("ingredient_id")
        Long ingredientId,

        @NotNull
        TransactionType transactionType,

        @Positive
        @Digits(integer = 19, fraction = 2)
        BigDecimal quantity,

        @PastOrPresent
        LocalDateTime transactionDate
) {
}
