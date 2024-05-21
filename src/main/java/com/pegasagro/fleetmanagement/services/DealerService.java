package com.pegasagro.fleetmanagement.services;


import com.pegasagro.fleetmanagement.entities.Dealer;

public interface DealerService {

    public Dealer createDealer(Dealer dealer);
    public Dealer assignCustomerToDealer(Long dealerId, Long customerId);
    public Dealer unassignCustomerFromDealer(Long dealerId, Long customerId);
    public Dealer findDealerbyId(Long dealerId);
}
