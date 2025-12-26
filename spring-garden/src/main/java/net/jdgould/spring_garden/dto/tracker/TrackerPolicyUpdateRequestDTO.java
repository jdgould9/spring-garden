package net.jdgould.spring_garden.dto.tracker;


import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record TrackerPolicyUpdateRequestDTO(
        String name,
        String description,
        Integer intervalHours) {
}


