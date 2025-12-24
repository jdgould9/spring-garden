package net.jdgould.spring_garden.controller;

import net.jdgould.spring_garden.service.TrackerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tracking")
public class TrackerController {
    private TrackerService trackerService;

    public TrackerController(TrackerService trackerService){
        this.trackerService=trackerService;
    }
}
