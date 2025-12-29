package com.iscod.FAI.service;

import com.iscod.FAI.models.Car;
import com.iscod.FAI.models.Pilot;

import java.util.List;
import java.util.UUID;

public interface PilotService {

    List<Pilot> findAll();

    UUID save(Pilot pilot);

    void deleteById(UUID id);

    void associatePilotToCar(Pilot pilot, Car car);

    Pilot findById(UUID id);
}
