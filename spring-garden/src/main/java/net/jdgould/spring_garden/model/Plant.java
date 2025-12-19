//Plant.java
//Represents a single plant within a garden
package net.jdgould.spring_garden.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Entity
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plantId;
    @Column(nullable = false)
    private String plantName;

    @ManyToOne
    @JoinColumn(nullable = false)
    private GardenZone gardenZone;

    @Embedded
    private PlantTracker plantTracker;

    protected Plant() {
    }

    public Plant(GardenZone gardenZone, String plantName) {
        this.gardenZone = gardenZone;
        this.plantName = plantName;
        this.plantTracker = PlantTracker.create();
    }

    //EVENT HANDLERS (DELEGATION)
    public TrackerEvent recordEvent(PlantTrackerEventType eventType, String details) {
        return switch(eventType){
            case WATER ->plantTracker.recordWatering(details);
            case FERTILIZE -> plantTracker.recordFertilization(details);
            case PRUNE -> plantTracker.recordPruning(details);
            case PEST_TREATMENT -> plantTracker.recordPestTreatment(details);
        };
    }

    //SETTERS
    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    //CLASS GETTERS
    public Long getPlantId() {
        return plantId;
    }

    public String getPlantName() {
        return plantName;
    }

    public GardenZone getGardenZone() {
        return gardenZone;
    }

    //TRACKER GETTERS
    public PlantTracker getTracker() {
        return this.plantTracker;
    }


}
