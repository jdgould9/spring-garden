package net.jdgould.spring_garden.dto.garden;

import net.jdgould.spring_garden.dto.gardenzone.GardenZoneSummaryDTO;
import net.jdgould.spring_garden.model.GardenZone;

import java.util.List;

public record GardenGetResponseDTO(Long gardenId,
                                   String gardenName,
                                   List<GardenZoneSummaryDTO> gardenZones) {
}
