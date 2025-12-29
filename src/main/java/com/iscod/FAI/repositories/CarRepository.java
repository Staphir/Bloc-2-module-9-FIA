package com.iscod.FAI.repositories;

import com.iscod.FAI.models.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CarRepository extends CrudRepository<Car, UUID> {
}
