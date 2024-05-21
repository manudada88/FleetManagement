package com.pegasagro.fleetmanagement.repositories.impl;

import com.pegasagro.fleetmanagement.entities.Car;
import com.pegasagro.fleetmanagement.exceptions.DataAccessException;
import com.pegasagro.fleetmanagement.exceptions.RecordNotFoundException;
import com.pegasagro.fleetmanagement.repositories.CarDAO;
import com.pegasagro.fleetmanagement.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDAOImpl implements CarDAO {

    @Autowired
    CarRepository carRepository;

    public Car createCar(Car car)  {
        try {
            return carRepository.save(car);
        }catch(Exception e) {
            throw new DataAccessException("Unable to create Car, problem related to DB");
        }
    }

    public Car findCar(String uniqueNumber) {
        return carRepository.findById(uniqueNumber).orElseThrow(()
                -> new RecordNotFoundException("Car with uniqueNumber: "+uniqueNumber+" not found"));
    }

}
