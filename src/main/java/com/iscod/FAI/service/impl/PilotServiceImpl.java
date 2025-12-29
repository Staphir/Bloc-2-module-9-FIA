package com.iscod.FAI.service.impl;

import com.iscod.FAI.exceptions.ResourceNotFoundException;
import com.iscod.FAI.models.Car;
import com.iscod.FAI.models.Pilot;
import com.iscod.FAI.repositories.PilotRepository;
import com.iscod.FAI.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PilotServiceImpl implements PilotService {

    @Autowired
    private PilotRepository pilotRepository;

    @Override
    public List<Pilot> findAll() {
        List<Pilot> pilots = new ArrayList<>();
        pilotRepository.findAll().forEach(pilots::add);
        return pilots;
    }

    @Override
    public UUID save(Pilot pilot) {
        return pilotRepository.save(pilot).getId();
    }

    @Override
    public void deleteById(UUID id) {
        pilotRepository.deleteById(id);
    }

    @Override
    public void associatePilotToCar(Pilot pilot, Car car) {
        pilot.setCar(car);
        pilotRepository.save(pilot);
    }

    @Override
    public Pilot findById(UUID id) {
        return pilotRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}
