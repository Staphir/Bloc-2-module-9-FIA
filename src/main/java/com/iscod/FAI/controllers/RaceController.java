package com.iscod.FAI.controllers;

import com.iscod.FAI.models.Pilot;
import com.iscod.FAI.models.Race;
import com.iscod.FAI.service.PilotService;
import com.iscod.FAI.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/races")
public class RaceController {

    @Autowired
    private RaceService raceService;

    @Autowired
    private PilotService pilotService;

    @GetMapping("/{id}")
    public Race findById(@PathVariable UUID id) {
        return raceService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UUID save(@RequestBody Race race) {
        return raceService.save(race);
    }

    @PostMapping("/{idRace}/associatePilot/{idPilot}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void associateRaceWithPilot(@PathVariable UUID idRace, @PathVariable UUID idPilot) {
        Race race = raceService.findById(idRace);
        Pilot pilot = pilotService.findById(idPilot);
        raceService.associateRaceWithPilot(race, pilot);
    }

    @PostMapping("/{idRace}/startRace/{speed}/{start}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void startRace(@PathVariable UUID idRace, @PathVariable Integer speed, @PathVariable Boolean start) {
        Race race = raceService.findById(idRace);
        raceService.startRace(race, speed, start);
    }
}
