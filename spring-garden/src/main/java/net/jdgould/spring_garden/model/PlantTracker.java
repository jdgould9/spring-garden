//PlantTracker.java
//Represents a single plant's tracker
package net.jdgould.spring_garden.model;

import jakarta.persistence.*;

import javax.sound.midi.Track;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class PlantTracker {
    @Column(nullable = false, updatable = false)
    private LocalDateTime creationDate; //time plant was added to the garden section

    @ElementCollection
    @CollectionTable(name = "watering_history")
    @OrderColumn
    private List<TrackerEvent> wateringHistory = new ArrayList<>(); //times plant was watered

    @ElementCollection
    @CollectionTable(name = "fertilization_history")
    @OrderColumn
    private List<TrackerEvent> fertilizationHistory = new ArrayList<>(); //times plant was fertilized

    @ElementCollection
    @CollectionTable(name = "pruning_history")
    @OrderColumn
    private List<TrackerEvent> pruningHistory = new ArrayList<>(); //times plant was pruned

    @ElementCollection
    @CollectionTable(name = "pest_treatment_history")
    @OrderColumn
    private List<TrackerEvent> pestTreatmentHistory = new ArrayList<>(); //times plant was treated for pests

    protected PlantTracker() {
    }

    public static PlantTracker create() {
        PlantTracker plantTracker = new PlantTracker();
        plantTracker.creationDate = LocalDateTime.now();
        return plantTracker;
    }

    //EVENT HANDLERS
    public TrackerEvent recordWatering(String details) {
        TrackerEvent event = new TrackerEvent(LocalDateTime.now(), details);
        wateringHistory.add(event);
        return event;
    }

    protected TrackerEvent recordFertilization(String details) {
        TrackerEvent event = new TrackerEvent(LocalDateTime.now(), details);
        fertilizationHistory.add(new TrackerEvent(LocalDateTime.now(), details));
        return event;
    }

    protected TrackerEvent recordPruning(String details) {
        TrackerEvent event = new TrackerEvent(LocalDateTime.now(), details);
        pruningHistory.add(new TrackerEvent(LocalDateTime.now(), details));
        return event;
    }

    protected TrackerEvent recordPestTreatment(String details) {
        TrackerEvent event = new TrackerEvent(LocalDateTime.now(), details);
        pestTreatmentHistory.add(new TrackerEvent(LocalDateTime.now(), details));
        return event;
    }

    //GETTERS
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public List<TrackerEvent> getWateringHistory() {
        return wateringHistory;
    }

    public List<TrackerEvent> getFertilizationHistory() {
        return fertilizationHistory;
    }

    public List<TrackerEvent> getPruningHistory() {
        return pruningHistory;
    }

    public List<TrackerEvent> getPestTreatmentHistory() {
        return pestTreatmentHistory;
    }
}
