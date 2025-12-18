package net.jdgould.spring_garden.service;

import net.jdgould.spring_garden.model.Garden;
import net.jdgould.spring_garden.model.GardenZone;
import net.jdgould.spring_garden.repository.GardenZoneRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class GardenZoneService {
    private final GardenZoneRepository gardenZoneRepository;
    private final GardenService gardenService;

    public GardenZoneService(GardenZoneRepository gardenZoneRepository, GardenService gardenService) {
        this.gardenZoneRepository = gardenZoneRepository;
        this.gardenService = gardenService;
    }

    public List<GardenZone> findAllGardenZonesInGarden(Long gardenId){
        Garden garden = gardenService.findGardenEntityById(gardenId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Garden not found"));
        return gardenZoneRepository.findAllByGarden(garden);
    }

    public Optional<GardenZone> findGardenZoneById(Long gardenZoneId, Long gardenId){
        Garden garden = gardenService.findGardenEntityById(gardenId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Garden not found"));
        return gardenZoneRepository.findByGardenZoneIdAndGarden(gardenZoneId,garden);
    }

    public GardenZone addGardenZoneToGarden(Long gardenId, String gardenZoneName){
        Garden garden = gardenService.findGardenEntityById(gardenId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Garden not found"));
        GardenZone gardenZone = new GardenZone(garden, gardenZoneName);
        return gardenZoneRepository.save(gardenZone);
    }
}
