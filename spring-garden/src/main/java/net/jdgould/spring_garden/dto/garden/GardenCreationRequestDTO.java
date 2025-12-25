package net.jdgould.spring_garden.dto.garden;

import jakarta.validation.constraints.NotBlank;

public record GardenCreationRequestDTO(
        @NotBlank String gardenName) {
}
