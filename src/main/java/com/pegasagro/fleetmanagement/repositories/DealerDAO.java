package com.pegasagro.fleetmanagement.repositories;


import com.pegasagro.fleetmanagement.entities.Dealer;

public interface DealerDAO {

    public Dealer createDealer(Dealer dealer);
    public Dealer findDealer(Long dealerId);
    public Dealer assignCustomerToDealer(Long dealerId, long customerId);
    public Dealer unassignCustomerToDealer(Long dealerId, long customerId);
}
