package com.pegasagro.fleetmanagement.repositories.impl;

import com.pegasagro.fleetmanagement.entities.Customer;
import com.pegasagro.fleetmanagement.entities.Dealer;
import com.pegasagro.fleetmanagement.exceptions.DataAccessException;
import com.pegasagro.fleetmanagement.exceptions.RecordNotFoundException;
import com.pegasagro.fleetmanagement.repositories.DealerDAO;
import com.pegasagro.fleetmanagement.repositories.DealerRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Transactional
@Repository
public class DealerDAOImpl implements DealerDAO {

    @Autowired
    DealerRepository dealerRepository;

    @Autowired
    EntityManager entityManager;

    public Dealer createDealer(Dealer dealer)  {
        try {
            return dealerRepository.save(dealer);
        }catch(Exception e) {
            throw new DataAccessException("Unable to create Dealer, problem related to DB");
        }
    }

    public Dealer findDealer(Long dealerId) {
        return dealerRepository.findById(dealerId).orElseThrow(()
                -> new RecordNotFoundException("Dealer with dealerId: "+dealerId+" not found"));
    }

    public Dealer assignCustomerToDealer(Long dealerId, long customerId) {
        Dealer dealer = findDealer(dealerId);
        try {
            Customer customer = entityManager.find(Customer.class, customerId);
            dealer.assignCustomer(customer);
            customer.assignDealer(dealer);
            entityManager.persist(customer);
            return dealer;
        } catch (Exception e) {
            throw new RecordNotFoundException("unable to assign or Customer with custumerId: "+customerId+" not found");
        }
    }

    public Dealer unassignCustomerToDealer(Long dealerId, long customerId) {
        Dealer dealer = findDealer(dealerId);
        try {
            Customer customer = entityManager.find(Customer.class, customerId);
            dealer.unassignCustomer(customer);
            customer.unassignCustomer(dealer);
            entityManager.persist(customer);
            return dealer;
        } catch (Exception e) {
            throw new RecordNotFoundException("unable to unassign or Customer with custumerId: "+customerId+" not found");
        }
    }

}
