package com.iscod.FAI.repositories;

import com.iscod.FAI.models.Pilot;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PilotRepository extends CrudRepository<Pilot, UUID> {
}
