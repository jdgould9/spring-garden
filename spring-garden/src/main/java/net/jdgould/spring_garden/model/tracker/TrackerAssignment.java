//TrackerAssignment.java
package net.jdgould.spring_garden.model.tracker;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tracker_assignment")
public class TrackerAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tracker_assignment_id")
    private Long trackerAssignmentId;

    @ManyToOne
    @JoinColumn(name = "tracker_id", nullable = false)
    private Tracker tracker;

    @ManyToOne
    @JoinColumn(name = "trackable_id", nullable = false)
    private Trackable assignedTo;

    @Column(name = "assignment_start_time", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime startDate;

    protected TrackerAssignment() {
    }

    public TrackerAssignment(Tracker tracker, Trackable assignedTo) {
        this.tracker = tracker;
        this.assignedTo = assignedTo;
    }
}
