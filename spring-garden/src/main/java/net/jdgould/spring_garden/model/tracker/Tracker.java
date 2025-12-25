//Tracker.java
package net.jdgould.spring_garden.model.tracker;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "tracker")
public class Tracker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tracker_id")
    private Long trackerId;

    @Column(name = "tracker_name", nullable = false)
    private String name; //Watering, weeding, etc.

    @Column(name = "tracker_description")
    private String description; //Water the plants in the rear, weed the front yard, etc.

    @Column(name = "interval_hours", nullable = false)
    private Integer intervalHours; //How often this action should be performed

    @Column(name = "creation_time", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime creationTime;

    protected Tracker() {
    }

    public Tracker(String name, String description, Integer intervalHours) {
        this.name = name;
        this.description = description;
        this.intervalHours = intervalHours;
    }
}
