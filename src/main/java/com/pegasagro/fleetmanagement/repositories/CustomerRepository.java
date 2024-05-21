package com.pegasagro.fleetmanagement.repositories;

import com.pegasagro.fleetmanagement.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
