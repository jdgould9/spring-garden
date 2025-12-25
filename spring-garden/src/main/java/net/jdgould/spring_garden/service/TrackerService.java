package net.jdgould.spring_garden.service;

import net.jdgould.spring_garden.repository.TrackableRepository;

public class TrackerService {
    private final TrackableRepository trackableRepository;

    public TrackerService(TrackableRepository trackableRepository) {
        this.trackableRepository = trackableRepository;
    }
}
