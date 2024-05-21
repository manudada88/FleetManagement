package com.pegasagro.fleetmanagement.controllers;

import com.pegasagro.fleetmanagement.entities.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface FleetController {
    public ResponseEntity<Car> createCar(Car car);
    public ResponseEntity<Customer> createCustomer(Customer customer);
    public ResponseEntity<Customer> getCustomer(Long customerId);
    public ResponseEntity<Dealer> createDealer(Dealer dealer);
    public ResponseEntity<Dealer> getDealer(Long dealerId);

    public ResponseEntity<Customer> assignCarToCustomer(CarAssignment carAssignment);
    public ResponseEntity<Dealer> assignCustomerToDealer(CustomerAssignment customerAssignment);
    public ResponseEntity<Customer> unassignCarFromCustomer(CarAssignment carAssignment);
    public ResponseEntity<Dealer> unassignCustomerFromDealer(CustomerAssignment customerAssignment);
}
