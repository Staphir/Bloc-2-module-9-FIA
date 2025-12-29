package com.iscod.FAI.repositories;

import com.iscod.FAI.models.Race;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RaceRepository extends CrudRepository<Race, UUID> {
}
