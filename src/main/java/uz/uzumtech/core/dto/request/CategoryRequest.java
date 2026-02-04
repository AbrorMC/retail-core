package uz.uzumtech.core.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequest(

        @NotBlank
        String name,

        @NotBlank
        String description
) {
}
