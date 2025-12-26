//Garden.java
package net.jdgould.spring_garden.model.garden;

import jakarta.persistence.*;
import net.jdgould.spring_garden.model.gardenzone.GardenZone;
import net.jdgould.spring_garden.model.tracker.Trackable;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "garden")
public class Garden extends Trackable {
    @OneToMany(mappedBy = "garden", cascade = CascadeType.ALL, orphanRemoval = true)
    List<GardenZone> gardenZones = new ArrayList<>();

    protected Garden() {
    }

    public Garden(String gardenName) {
        super(gardenName);
    }

    public List<GardenZone> getGardenZones(){
        return this.gardenZones;
    }

    public void addGardenZone(GardenZone gardenZone){
        this.gardenZones.add(gardenZone);
        gardenZone.setGarden(this);
    }

    public void removeGardenZone(GardenZone gardenZone){
        this.gardenZones.remove(gardenZone);
        gardenZone.setGarden(null);
    }
}
