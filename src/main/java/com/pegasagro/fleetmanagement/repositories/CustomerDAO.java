package com.pegasagro.fleetmanagement.repositories;


import com.pegasagro.fleetmanagement.entities.Customer;

public interface CustomerDAO {

    public Customer createCustomer(Customer customer);
    public Customer findCustomer(Long customerId);
    public Customer assignCarToCustomer(long customerId, String assignCarUniqueNumber);
    public Customer unassignCarFromCustomer(long customerId, String assignCarUniqueNumber);
}
