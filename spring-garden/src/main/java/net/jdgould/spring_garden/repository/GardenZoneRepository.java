package net.jdgould.spring_garden.repository;

import net.jdgould.spring_garden.model.Garden;
import net.jdgould.spring_garden.model.GardenZone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GardenZoneRepository extends JpaRepository<GardenZone, Long> {
    List<GardenZone> findAllByGarden(Garden garden);

    Optional<GardenZone> findByGardenZoneIdAndGarden(Long gardenZoneId, Garden garden);
}
