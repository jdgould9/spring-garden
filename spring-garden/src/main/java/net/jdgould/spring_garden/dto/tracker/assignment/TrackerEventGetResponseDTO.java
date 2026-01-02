package net.jdgould.spring_garden.dto.tracker.assignment;

import java.time.LocalDateTime;

public record TrackerEventGetResponseDTO(Long trackerEventId,
                                         LocalDateTime recordedTime,
                                         String details) {
}
