//TrackerEvent.java
package net.jdgould.spring_garden.model.tracker;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="tracker_event")
public class TrackerEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tracker_event_id")
    private Long trackerEventId;

    @ManyToOne
    @JoinColumn(name = "tracker_assignment_id", nullable = false)
    private TrackerAssignment trackerAssignment;

    @Column(name = "eventDetails")
    private String details;

    @Column(name = "event_recorded_time", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime recordedTime;

    protected TrackerEvent() {
    }

    public TrackerEvent(TrackerAssignment trackerAssignment, String details) {
        this.trackerAssignment = trackerAssignment;
        this.details = details;
    }

    public void setTrackerAssignment(TrackerAssignment trackerAssignment) {
        this.trackerAssignment = trackerAssignment;
    }

    public Long getTrackerEventId() {
        return trackerEventId;
    }

    public LocalDateTime getRecordedTime() {
        return recordedTime;
    }

    public String getDetails() {
        return details;
    }
}