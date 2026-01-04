//Trackable.java
package net.jdgould.spring_garden.model.tracker;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Trackable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trackable_id")
    private Long id;

    @Column(name = "trackable_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "assignedTo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrackerAssignment> trackerAssignments = new ArrayList<>();

    protected Trackable() {
    }

    public Trackable(String name) {
        this.name = name;
    }

    public abstract TrackableType getTrackableType();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void removeTrackerAssignment(TrackerAssignment trackerAssignment){
        this.trackerAssignments.remove(trackerAssignment);
        trackerAssignment.setTrackerPolicy(null);
    }

}