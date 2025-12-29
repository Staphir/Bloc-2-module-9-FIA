package com.iscod.FAI.service.impl;

import com.iscod.FAI.exceptions.ResourceNotFoundException;
import com.iscod.FAI.models.Car;
import com.iscod.FAI.repositories.CarRepository;
import com.iscod.FAI.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        carRepository.findAll().forEach(cars::add);
        return cars;
    }

    @Override
    public Car findById(UUID id) {
        return carRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public UUID save(Car car) {
        return carRepository.save(car).getId();
    }
}
