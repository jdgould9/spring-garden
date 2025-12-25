package net.jdgould.spring_garden.repository;

import net.jdgould.spring_garden.model.tracker.Trackable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackableRepository extends JpaRepository<Trackable, Long> {
}
