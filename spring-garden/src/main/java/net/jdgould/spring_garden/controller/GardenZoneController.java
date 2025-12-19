package net.jdgould.spring_garden.controller;

import net.jdgould.spring_garden.dto.gardenzone.GardenZoneCreationRequestDTO;
import net.jdgould.spring_garden.dto.gardenzone.GardenZoneCreationResponseDTO;
import net.jdgould.spring_garden.dto.gardenzone.GardenZoneGetResponseDTO;
import net.jdgould.spring_garden.dto.tracker.GardenZoneTrackerEventCreationRequestDTO;
import net.jdgould.spring_garden.dto.tracker.TrackerEventCreationResponseDTO;
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
    public List<GardenZoneGetResponseDTO> getAllGardenZonesInGarden(@PathVariable("gardenId") Long gardenId) {
        return gardenZoneService.findAllGardenZonesInGarden(gardenId);
    }

    //Get garden zone by garden Id and garden zone Id
    @GetMapping("/{gardenZoneId}")
    public GardenZoneGetResponseDTO getGardenZoneById(@PathVariable("gardenId") Long gardenId, @PathVariable("gardenZoneId") Long gardenZoneId) {
        return gardenZoneService.findGardenZoneById(gardenZoneId, gardenId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Garden not found"));
    }

    //Create garden zone
    @PostMapping("")
    public GardenZoneCreationResponseDTO createGardenZone(@PathVariable("gardenId") Long gardenId, @RequestBody GardenZoneCreationRequestDTO request) {
        return gardenZoneService.addGardenZoneToGarden(gardenId, request);
    }

    //Record tracker event
    @PostMapping("{gardenZoneId}/tracker")
    public TrackerEventCreationResponseDTO recordTrackerEvent(@PathVariable("gardenId") Long gardenId,
                                                              @PathVariable("gardenZoneId") Long gardenZoneId,
                                                              @RequestBody GardenZoneTrackerEventCreationRequestDTO request){

        return gardenZoneService.recordEvent(gardenId, gardenZoneId, request);
    }
}
