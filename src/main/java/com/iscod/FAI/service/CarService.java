package com.iscod.FAI.service;

import com.iscod.FAI.models.Car;

import java.util.List;
import java.util.UUID;

public interface CarService {
    List<Car> findAll();

    Car findById(UUID id);

    UUID save(Car car);
}
