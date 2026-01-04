package net.jdgould.spring_garden.dto.tracker.trackable;

import net.jdgould.spring_garden.model.tracker.TrackableType;

public record TrackableGetResponseDTO(Long trackableId,
                                      String trackableName,
                                      TrackableType trackableType) {
}
