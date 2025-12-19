package net.jdgould.spring_garden.dto.tracker;

import net.jdgould.spring_garden.model.PlantTrackerEventType;

public record PlantTrackerEventCreationRequestDTO(PlantTrackerEventType plantTrackerEventType, String details){
}
