package net.jdgould.spring_garden.controller;

import net.jdgould.spring_garden.dto.tracker.TrackerPolicyCreationRequestDTO;
import net.jdgould.spring_garden.dto.tracker.TrackerPolicyCreationResponseDTO;
import net.jdgould.spring_garden.dto.tracker.TrackerPolicyGetResponseDTO;
import net.jdgould.spring_garden.dto.tracker.TrackerPolicyUpdateRequestDTO;
import net.jdgould.spring_garden.service.TrackerPolicyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracker")
public class TrackerController {
    private TrackerPolicyService trackerPolicyService;

    public TrackerController(TrackerPolicyService trackerPolicyService){
        this.trackerPolicyService = trackerPolicyService;
    }

    //Create a new tracking policy
    @PostMapping("")
    public ResponseEntity<TrackerPolicyCreationResponseDTO> createTrackerPolicy(@RequestBody TrackerPolicyCreationRequestDTO request){
        return null;
    }

    //Get all tracking policies
    @GetMapping("")
    public List<TrackerPolicyGetResponseDTO> getAllTrackerPolicies(){
        return trackerPolicyService.findAllTrackerPolicies();
    }

    //Get tracking policy
    @GetMapping("/{trackerPolicyId}")
    public TrackerPolicyGetResponseDTO getTrackerPolicyById(@PathVariable("trackerPolicyId") Long trackerPolicyId){
        return trackerPolicyService.findTrackerPolicyById(trackerPolicyId);
    }

    //Delete tracking policy
    @DeleteMapping("/{trackerPolicyId}")
    public ResponseEntity<Void> deleteTrackerPolicyById(@PathVariable("trackerPolicyId") Long trackerPolicyId){
        trackerPolicyService.deleteTrackerPolicyById(trackerPolicyId);
        return ResponseEntity.noContent().build();
    }

    //Update tracking policy
    @PatchMapping("{trackerPolicyId}")
    public ResponseEntity<TrackerPolicyGetResponseDTO> updateTrackerPolicyById(@PathVariable("trackerPolicyId") Long trackerPolicyId, @RequestBody TrackerPolicyUpdateRequestDTO request){
        TrackerPolicyGetResponseDTO response = trackerPolicyService.updateTrackerPolicyById(trackerPolicyId, request);
        return ResponseEntity.ok(response);
    }
}
