package com.pegasagro.fleetmanagement.repositories;

import com.pegasagro.fleetmanagement.entities.Car;
import com.pegasagro.fleetmanagement.exceptions.DataAccessException;
import com.pegasagro.fleetmanagement.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


public interface CarDAO {

    public Car createCar(Car car);
    public Car findCar(String uniqueNumber);
}
