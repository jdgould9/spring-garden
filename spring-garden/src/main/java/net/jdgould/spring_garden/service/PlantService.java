package net.jdgould.spring_garden.service;

import net.jdgould.spring_garden.model.GardenZone;
import net.jdgould.spring_garden.model.Plant;
import net.jdgould.spring_garden.repository.PlantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PlantService {
    private final PlantRepository plantRepository;
    private final GardenZoneService gardenZoneService;

    public PlantService(PlantRepository plantRepository, GardenZoneService gardenZoneService) {
        this.plantRepository = plantRepository;
        this.gardenZoneService = gardenZoneService;
    }

    public List<Plant> findAllPlantsInZone(Long gardenId, Long gardenZoneId){
        GardenZone gardenZone = gardenZoneService.findGardenZoneById(gardenZoneId, gardenId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return plantRepository.findAllByGardenZone(gardenZone);
    }

    public Optional<Plant> findPlantInZoneById(Long gardenId, Long gardenZoneId, Long plantId){
        GardenZone gardenZone = gardenZoneService.findGardenZoneById(gardenZoneId, gardenId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return plantRepository.findByPlantIdAndGardenZone(plantId, gardenZone);
    }

    public Plant addPlantToGardenZone(Long gardenId, Long gardenZoneId, String plantName){
        GardenZone gardenZone = gardenZoneService.findGardenZoneById(gardenZoneId, gardenId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        Plant plant = new Plant(gardenZone, plantName);
        return plantRepository.save(plant);
    }



    //SERVICES

//    public Optional<Plant> getPlantById(Long id) {
//        return plantRepository.findById(id);
//    }
//
//    public List<Plant> getAllPlants() {
//        return plantRepository.findAll();
//    }
//
//    public Plant addPlant(Plant plant) {
//        return plantRepository.save(plant);
//    }
}

