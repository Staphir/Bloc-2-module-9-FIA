package com.iscod.FAI.service.impl;

import com.iscod.FAI.exceptions.ResourceNotFoundException;
import com.iscod.FAI.models.Car;
import com.iscod.FAI.models.Pilot;
import com.iscod.FAI.models.Race;
import com.iscod.FAI.repositories.RaceRepository;
import com.iscod.FAI.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RaceServiceImpl implements RaceService {

    @Autowired
    private RaceRepository raceRepository;

    @Override
    public Race findById(UUID id) {
        return raceRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public UUID save(Race race) {
        return raceRepository.save(race).getId();
    }

    @Override
    public void associateRaceWithPilot(Race race, Pilot pilot) {
        race.associatePilot(pilot);
        raceRepository.save(race);
    }

    @Override
    public void startRace(Race race, Integer speed, Boolean start) {
        if (Boolean.TRUE.equals(start)) {
            race.setStart(true);
            System.out.println("Begin Race !");
            race.getPilots().forEach(pilot -> {
                Car car = pilot.getCar();
                if (car != null && car.getSpeed() > speed) {
                    System.out.printf(
                            "The pilot %s can participate in the race with his car %s%n",
                            pilot.getName(),
                            car.getName()
                    );
                }
            });
        } else {
            race.setStart(false);
            System.out.println("End of race");
        }
        raceRepository.save(race);
    }
}
