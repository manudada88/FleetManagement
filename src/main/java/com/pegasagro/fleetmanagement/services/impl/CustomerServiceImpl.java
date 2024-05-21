package com.pegasagro.fleetmanagement.services.impl;


import com.pegasagro.fleetmanagement.entities.Customer;
import com.pegasagro.fleetmanagement.repositories.CustomerDAO;
import com.pegasagro.fleetmanagement.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    public Customer createCustomer(Customer customer) {
        return customerDAO.createCustomer(customer);
    }

    public Customer assignCarToCustomer(long customerId, String carUniqueNumber) {
        return customerDAO.assignCarToCustomer(customerId, carUniqueNumber);
    }

    public Customer unassignCarFromCustomer(Long customerId, String carUniqueNumber) {
        return customerDAO.unassignCarFromCustomer(customerId, carUniqueNumber);
    }

    public Customer findCustomerbyId(Long customerId){
        return customerDAO.findCustomer(customerId);
    }
}
