package net.jdgould.spring_garden.dto.tracker.assignment;

import java.time.LocalDateTime;

public record TrackerEventCreationResponseDTO(Long trackerEventId,
                                              LocalDateTime recordedTime) {
}
