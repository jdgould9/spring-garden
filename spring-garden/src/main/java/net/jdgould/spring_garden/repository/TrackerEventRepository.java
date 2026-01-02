package net.jdgould.spring_garden.repository;

import net.jdgould.spring_garden.model.tracker.TrackerAssignment;
import net.jdgould.spring_garden.model.tracker.TrackerEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrackerEventRepository extends JpaRepository<TrackerEvent,Long> {
    List<TrackerEvent> findAllByTrackerAssignment(TrackerAssignment trackerAssignment);
    Optional<TrackerEvent> findTrackerEventByTrackerEventIdAndTrackerAssignment(Long trackerEventId, TrackerAssignment trackerAssignment);
    Optional<TrackerEvent> findTopByTrackerAssignmentOrderByRecordedTimeDesc(TrackerAssignment trackerAssignment);
}