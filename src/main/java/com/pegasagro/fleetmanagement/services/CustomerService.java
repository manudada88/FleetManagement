package com.pegasagro.fleetmanagement.services;

import com.pegasagro.fleetmanagement.entities.Car;
import com.pegasagro.fleetmanagement.entities.Customer;
public interface CustomerService {
    public Customer createCustomer(Customer customer);
    public Customer assignCarToCustomer(long customerId, String carUniqueNumber);
    public Customer unassignCarFromCustomer(Long customerId, String carUniqueNumber);
    public Customer findCustomerbyId(Long customerId);
}
