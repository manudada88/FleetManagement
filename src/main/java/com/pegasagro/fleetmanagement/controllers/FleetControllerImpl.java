package com.pegasagro.fleetmanagement.controllers;

import com.pegasagro.fleetmanagement.entities.*;
import com.pegasagro.fleetmanagement.services.CarService;
import com.pegasagro.fleetmanagement.services.CustomerService;
import com.pegasagro.fleetmanagement.services.DealerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FleetControllerImpl implements FleetController{

    @Autowired
    CarService carService;

    @Autowired
    CustomerService customerService;

    @Autowired
    DealerService dealerService;

    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@Valid @RequestBody Car car) {
        Car newCar = carService.createCar(car);
        return new ResponseEntity<>(newCar, HttpStatus.CREATED);
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
        Customer newCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long customerId) {
        Customer customer = customerService.findCustomerbyId(customerId);
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/dealers")
    public ResponseEntity<Dealer> createDealer(@Valid @RequestBody Dealer dealer) {
        Dealer newDealer = dealerService.createDealer(dealer);
        return new ResponseEntity<>(newDealer, HttpStatus.CREATED);
    }

    @GetMapping("/dealers/{dealerId}")
    public ResponseEntity<Dealer> getDealer(@PathVariable Long dealerId) {
        Dealer dealer = dealerService.findDealerbyId(dealerId);
        return ResponseEntity.ok(dealer);
    }

    @PostMapping("/assign-car-customer")
    public ResponseEntity<Customer> assignCarToCustomer(@Valid @RequestBody CarAssignment carAssignment) {
        Customer owner = customerService.assignCarToCustomer(carAssignment.getCustomerId(),
                carAssignment.getCarUniqueNumber());
        return ResponseEntity.ok(owner);
    }

    @PostMapping("/assign-customer-dealer")
    public ResponseEntity<Dealer> assignCustomerToDealer(@Valid @RequestBody CustomerAssignment customerAssignment) {
        Dealer dealer = dealerService.assignCustomerToDealer(customerAssignment.getDealerId(),
                customerAssignment.getCustomerId());
        return ResponseEntity.ok(dealer);
    }

    @PostMapping("/unassign-car-customer")
    public ResponseEntity<Customer> unassignCarFromCustomer(@Valid @RequestBody CarAssignment carAssignment) {
        Customer owner = customerService.unassignCarFromCustomer(carAssignment.getCustomerId(),
                carAssignment.getCarUniqueNumber());
        return ResponseEntity.ok(owner);
    }

    @PostMapping("/unassign-customer-dealer")
    public ResponseEntity<Dealer> unassignCustomerFromDealer(@Valid @RequestBody CustomerAssignment customerAssignment) {
        Dealer dealer = dealerService.unassignCustomerFromDealer(customerAssignment.getDealerId(),
                customerAssignment.getCustomerId());
        return ResponseEntity.ok(dealer);
    }

}
