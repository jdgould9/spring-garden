package net.jdgould.spring_garden.controller;

import net.jdgould.spring_garden.model.Plant;
import net.jdgould.spring_garden.service.PlantService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/gardens/{gardenId}/zones/{gardenZoneId}/plants")
public class PlantController {
    private PlantService plantService;

    public PlantController(PlantService plantService){
        this.plantService=plantService;
    }

    //Get all plants in a garden zone
    @GetMapping("")
    public List<Plant> getAllPlantsInGardenZone(@PathVariable("gardenId") Long gardenId, @PathVariable("gardenZoneId") Long gardenZoneId){
        return plantService.findAllPlantsInZone(gardenId, gardenZoneId);
    }

    //Get plant by plant Id and garden zone Id and garden Id
    @GetMapping("/{plantId}")
    public Plant getPlantById(@PathVariable("gardenId")  Long gardenId, @PathVariable("gardenZoneId") Long gardenZoneId, @PathVariable("plantId") Long plantId){
        return plantService.findPlantInZoneById(gardenId, gardenZoneId, plantId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Garden not found"));
    }

    //Create plant
    @PostMapping("")
    public Plant createPlant(@PathVariable("gardenId")  Long gardenId, @PathVariable("gardenZoneId") Long gardenZoneId, @RequestBody Map<String,String> plantRequest){
        String plantName = plantRequest.get("plantName");
        return plantService.addPlantToGardenZone(gardenId, gardenZoneId, plantName);
    }
}
