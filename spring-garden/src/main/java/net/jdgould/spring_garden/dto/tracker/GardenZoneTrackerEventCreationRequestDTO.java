package net.jdgould.spring_garden.dto.tracker;

import net.jdgould.spring_garden.model.GardenZoneTrackerEventType;

public record GardenZoneTrackerEventCreationRequestDTO (GardenZoneTrackerEventType gardenZoneTrackerEventType, String details){
}
