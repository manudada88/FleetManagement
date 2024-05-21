package com.pegasagro.fleetmanagement.repositories.impl;

import com.pegasagro.fleetmanagement.entities.Car;
import com.pegasagro.fleetmanagement.entities.Customer;
import com.pegasagro.fleetmanagement.exceptions.DataAccessException;
import com.pegasagro.fleetmanagement.exceptions.RecordNotFoundException;
import com.pegasagro.fleetmanagement.repositories.CustomerDAO;
import com.pegasagro.fleetmanagement.repositories.CustomerRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    EntityManager entityManager;

    public Customer createCustomer(Customer customer) {
        try {
            return customerRepository.save(customer);
        } catch (Exception e) {
            throw new DataAccessException("Unable to create Customer, problem related to DB");
        }
    }

    public Customer findCustomer(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(()
                -> new RecordNotFoundException("Customer with customerId: "+customerId+" not found"));
    }

    public Customer assignCarToCustomer(long customerId, String assignCarUniqueNumber) {
        Customer owner = findCustomer(customerId);
        try {
            Car car = entityManager.find(Car.class, assignCarUniqueNumber);
            owner.addCar(car);
            car.setOwner(owner);
            entityManager.persist(car);
            return owner;
        } catch (Exception e) {
            throw new RecordNotFoundException("unable to assign or Car with uniqueNumber: "+assignCarUniqueNumber+" not found");
        }
    }

    public Customer unassignCarFromCustomer(long customerId, String assignCarUniqueNumber) {
        Customer owner = findCustomer(customerId);
        try {
            Car car = entityManager.find(Car.class, assignCarUniqueNumber);
            owner.removeCar(car);
            car.setOwner(null);
            entityManager.persist(car);
            return owner;
        } catch (Exception e) {
            throw new RecordNotFoundException("unable to unassign or Car with uniqueNumber: "+assignCarUniqueNumber+" not found");
        }
    }
}
