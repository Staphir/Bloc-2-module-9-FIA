package com.iscod.FAI.service;

import com.iscod.FAI.models.Pilot;
import com.iscod.FAI.models.Race;

import java.util.UUID;

public interface RaceService {
    Race findById(UUID id);

    UUID save(Race race);

    void associateRaceWithPilot(Race race, Pilot pilot);

    void startRace(Race race, Integer speed, Boolean start);
}
