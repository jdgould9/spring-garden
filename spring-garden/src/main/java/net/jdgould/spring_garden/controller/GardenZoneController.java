package net.jdgould.spring_garden.controller;

import net.jdgould.spring_garden.model.GardenZone;
import net.jdgould.spring_garden.service.GardenService;
import net.jdgould.spring_garden.service.GardenZoneService;
import net.jdgould.spring_garden.service.PlantService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/gardens/{gardenId}/zones")
public class GardenZoneController {
    private final GardenZoneService gardenZoneService;

    public GardenZoneController(GardenZoneService gardenZoneService) {
        this.gardenZoneService = gardenZoneService;
    }

    //Get all garden zones in a garden
    @GetMapping("")
    public List<GardenZone> getAllGardenZonesInGarden(@PathVariable("gardenId") Long gardenId) {
        return gardenZoneService.findAllGardenZonesInGarden(gardenId);
    }

    //Get garden zone by garden Id and garden zone Id
    @GetMapping("/{gardenZoneId}")
    public GardenZone getGardenZoneById(@PathVariable("gardenId") Long gardenId, @PathVariable("gardenZoneId") Long gardenZoneId) {
        return gardenZoneService.findGardenZoneById(gardenZoneId, gardenId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Garden not found"));
    }

    //Create garden zone
    @PostMapping("")
    public GardenZone createGardenZone(@PathVariable("gardenId") Long gardenId, @RequestBody Map<String, String> gardenZoneRequest) {
        String gardenZoneName = gardenZoneRequest.get("gardenZoneName");
        return gardenZoneService.addGardenZoneToGarden(gardenId, gardenZoneName);
    }
}
