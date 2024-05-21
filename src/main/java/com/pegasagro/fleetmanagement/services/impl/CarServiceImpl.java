package com.pegasagro.fleetmanagement.services.impl;

import com.pegasagro.fleetmanagement.entities.Car;
import com.pegasagro.fleetmanagement.repositories.CarDAO;
import com.pegasagro.fleetmanagement.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarDAO carDAO;

    public Car createCar(Car car) {
        return carDAO.createCar(car);
    }
}
