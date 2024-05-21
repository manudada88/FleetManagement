package com.pegasagro.fleetmanagement.repositories;

import com.pegasagro.fleetmanagement.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, String>{

}
