package net.jdgould.spring_garden.dto.gardenzone;

import net.jdgould.spring_garden.dto.plant.PlantGetResponseDTO;

import java.util.List;

public record GardenZoneGetResponseDTO(Long gardenZoneId,
                                       String gardenZoneName,
                                       List<PlantGetResponseDTO> plants)
{
}
