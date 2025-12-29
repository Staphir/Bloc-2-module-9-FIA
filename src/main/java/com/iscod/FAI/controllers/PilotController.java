package com.iscod.FAI.controllers;

import com.iscod.FAI.models.Car;
import com.iscod.FAI.models.Pilot;
import com.iscod.FAI.service.CarService;
import com.iscod.FAI.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pilots")
public class PilotController {

    @Autowired
    private PilotService pilotService;

    @Autowired
    private CarService carService;

    @GetMapping
    public List<Pilot> findAll() {
        return pilotService.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UUID save(@RequestBody Pilot pilot) {
        return pilotService.save(pilot);
    }

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@RequestParam UUID id) {
        pilotService.findById(id);
        pilotService.deleteById(id);
    }

    @PostMapping("/{idPilot}/associatePilotToCar/{idCar}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void associatePilotToCar(@RequestParam UUID idPilot, @RequestParam UUID idCar) {
        Pilot pilot = pilotService.findById(idPilot);
        Car car = carService.findById(idCar);
        pilotService.associatePilotToCar(pilot, car);
    }
}
