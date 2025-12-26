package net.jdgould.spring_garden.repository;

import net.jdgould.spring_garden.model.tracker.TrackerPolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackerPolicyRepository extends JpaRepository<TrackerPolicy,Long> {
}
