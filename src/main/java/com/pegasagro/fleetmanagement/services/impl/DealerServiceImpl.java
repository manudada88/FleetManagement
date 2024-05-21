package com.pegasagro.fleetmanagement.services.impl;


import com.pegasagro.fleetmanagement.entities.Dealer;
import com.pegasagro.fleetmanagement.repositories.DealerDAO;
import com.pegasagro.fleetmanagement.services.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealerServiceImpl implements DealerService {

    @Autowired
    DealerDAO dealerDAO;

    public Dealer createDealer(Dealer dealer) {
        return dealerDAO.createDealer(dealer);
    }

    public Dealer assignCustomerToDealer(Long dealerId, Long customerId) {
        return dealerDAO.assignCustomerToDealer(dealerId, customerId);
    }

    public Dealer unassignCustomerFromDealer(Long dealerId, Long customerId) {
        return dealerDAO.unassignCustomerToDealer(dealerId, customerId);
    }

    public Dealer findDealerbyId(Long dealerId){
        return dealerDAO.findDealer(dealerId);
    }
}
