//package net.jdgould.spring_garden.controller;
//
//import net.jdgould.spring_garden.dto.garden.GardenCreationRequestDTO;
//import net.jdgould.spring_garden.dto.garden.GardenCreationResponseDTO;
//import net.jdgould.spring_garden.dto.garden.GardenGetResponseDTO;
//import net.jdgould.spring_garden.model.GardenZone;
//import net.jdgould.spring_garden.model.Plant;
//import net.jdgould.spring_garden.service.GardenService;
//import net.jdgould.spring_garden.service.GardenZoneService;
//import net.jdgould.spring_garden.service.PlantService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/gardens")
//public class Controller {
//
//    private final GardenService gardenService;
//    private final GardenZoneService gardenZoneService;
//    private final PlantService plantService;
//
//    public Controller(GardenService gardenService, GardenZoneService gardenZoneService, PlantService plantService) {
//        this.gardenService = gardenService;
//        this.gardenZoneService = gardenZoneService;
//        this.plantService = plantService;
//
//    }
//
//    ///GARDEN
//    //Get all gardens
//    @GetMapping("")
//    public List<GardenGetResponseDTO> getAllGardens() {
//        return gardenService.findAllGardens();
//    }
//
//    //Get garden by Id
//    @GetMapping("/{gardenId}")
//    public GardenGetResponseDTO getGardenById(@PathVariable Long gardenId) {
//        return gardenService.findGardenById(gardenId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Garden not found"));
//    }
//
//    //Create garden
//    @PostMapping("")
//    public GardenCreationResponseDTO createGarden(@RequestBody GardenCreationRequestDTO gardenCreationRequestDTO) {
//        return gardenService.addGarden(gardenCreationRequestDTO);
//    }
//
//    ///GARDENZONE
//    //Get all garden zones in a garden
//    @GetMapping("/{gardenId}/zones")
//    public List<GardenZone> getAllGardenZonesInGarden(@PathVariable Long gardenId) {
//        return gardenZoneService.findAllGardenZonesInGarden(gardenId);
//    }
//
//    //Get garden zone by garden Id and garden zone Id
//    @GetMapping("/{gardenId}/zones/{gardenZoneId}")
//    public GardenZone getGardenZoneById(@PathVariable Long gardenId, @PathVariable Long gardenZoneId) {
//        return gardenZoneService.findGardenZoneById(gardenZoneId, gardenId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Garden not found"));
//    }
//
//    //Create garden zone
//    @PostMapping("/{gardenId}/zones")
//    public GardenZone createGardenZone(@PathVariable Long gardenId, @RequestBody Map<String, String> gardenZoneRequest) {
//        String gardenZoneName = gardenZoneRequest.get("gardenZoneName");
//        return gardenZoneService.addGardenZoneToGarden(gardenId, gardenZoneName);
//    }
//
//    ///PLANT
//    //Get all plants in a garden zone
//    @GetMapping("/{gardenId}/zones/{gardenZoneId}/plants")
//    public List<Plant> getAllPlantsInGardenZone(@PathVariable Long gardenId, @PathVariable Long gardenZoneId){
//        return plantService.findAllPlantsInZone(gardenId, gardenZoneId);
//    }
//
//    //Get plant by plant Id and garden zone Id and garden Id
//    @GetMapping("/{gardenId}/zones/{gardenZoneId}/plants/{plantId}")
//    public Plant getPlantById(@PathVariable Long gardenId, @PathVariable Long gardenZoneId, @PathVariable Long plantId){
//        return plantService.findPlantInZoneById(gardenId, gardenZoneId, plantId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Garden not found"));
//    }
//
//    //Create plant
//    @PostMapping("/{gardenId}/zones/{gardenZoneId}/plants")
//    public Plant createPlant(@PathVariable Long gardenId, @PathVariable Long gardenZoneId, @RequestBody Map<String,String> plantRequest){
//        String plantName = plantRequest.get("plantName");
//        return plantService.addPlantToGardenZone(gardenId, gardenZoneId, plantName);
//    }
//}