package net.jdgould.spring_garden.service;

import net.jdgould.spring_garden.dto.tracker.TrackerPolicyCreationRequestDTO;
import net.jdgould.spring_garden.dto.tracker.TrackerPolicyCreationResponseDTO;
import net.jdgould.spring_garden.dto.tracker.TrackerPolicyGetResponseDTO;
import net.jdgould.spring_garden.dto.tracker.TrackerPolicyUpdateRequestDTO;
import net.jdgould.spring_garden.exception.TrackerPolicyNotFoundException;
import net.jdgould.spring_garden.model.tracker.TrackerPolicy;
import net.jdgould.spring_garden.repository.TrackerPolicyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackerPolicyService {
    private final TrackerPolicyRepository trackerPolicyRepository;

    public TrackerPolicyService(TrackerPolicyRepository trackerPolicyRepository) {
        this.trackerPolicyRepository = trackerPolicyRepository;
    }

    public TrackerPolicyCreationResponseDTO addTrackerPolicy(TrackerPolicyCreationRequestDTO request) {
        TrackerPolicy savedTrackerPolicy = trackerPolicyRepository.save(new TrackerPolicy(request.name(), request.description(), request.intervalHours()));
        return new TrackerPolicyCreationResponseDTO(savedTrackerPolicy.getTrackerPolicyId());
    }

    public List<TrackerPolicyGetResponseDTO> findAllTrackerPolicies() {
        return trackerPolicyRepository.findAll().stream()
                .map(this::entityToGetResponseDTO)
                .toList();
    }

    public TrackerPolicyGetResponseDTO findTrackerPolicyById(Long trackerPolicyId) {
        TrackerPolicy trackerPolicy = findTrackerPolicyEntityById(trackerPolicyId);
        return entityToGetResponseDTO(trackerPolicy);
    }

    public void deleteTrackerPolicyById(Long trackerPolicyId) {
        TrackerPolicy trackerPolicy = findTrackerPolicyEntityById(trackerPolicyId);
        trackerPolicyRepository.delete(trackerPolicy);
    }

    public TrackerPolicyGetResponseDTO updateTrackerPolicyById(Long trackerPolicyId, TrackerPolicyUpdateRequestDTO request) {
        TrackerPolicy trackerPolicy = findTrackerPolicyEntityById(trackerPolicyId);
        if (request.name() != null && !request.name().isBlank()) {
            trackerPolicy.setName(request.name());
        }

        if (request.description() != null && !request.description().isBlank()) {
            trackerPolicy.setDescription(request.description());
        }

        if (request.intervalHours() != null && request.intervalHours() > 0) {
            trackerPolicy.setIntervalHours(request.intervalHours());
        }
        trackerPolicyRepository.save(trackerPolicy);
        return entityToGetResponseDTO(trackerPolicy);
    }

    //HELPERS
    private TrackerPolicyGetResponseDTO entityToGetResponseDTO(TrackerPolicy trackerPolicy) {
        return new TrackerPolicyGetResponseDTO(
                trackerPolicy.getTrackerPolicyId(),
                trackerPolicy.getName(),
                trackerPolicy.getDescription(),
                trackerPolicy.getIntervalHours(),
                trackerPolicy.getCreationTime()
        );
    }

    protected TrackerPolicy findTrackerPolicyEntityById(Long trackerPolicyId) {
        return trackerPolicyRepository.findById(trackerPolicyId)
                .orElseThrow(() -> new TrackerPolicyNotFoundException("Tracker policy not found with id: " + trackerPolicyId));
    }


}
