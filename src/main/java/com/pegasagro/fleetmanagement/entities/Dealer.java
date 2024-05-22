package com.pegasagro.fleetmanagement.entities;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "dealers")
public class Dealer {

    @Id
    @JoinColumn(name = "dealer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dealerId;

    @NotBlank(message = "Dealer name cannot be empty")
    @NotNull(message = "Dealer name cannot be Null")
    private String name;

    @Email(message = "EmailId is not valid")
    @NotBlank(message = "EmailId name cannot be blank")
    private String email;

    @NotBlank(message = "representativeFullName cannot be empty")
    @NotNull(message = "representativeFullName cannot be Null")
    private String representativeFullName;

    @ManyToMany(mappedBy = "dealersAssigned", fetch = FetchType.LAZY)
    private Set<Customer> customersList = new HashSet<>();

    public Dealer() {
    }

    public Dealer(Long dealerId,
                  String name,
                  String email,
                  String representativeFullName) {
        this.dealerId = dealerId;
        this.name = name;
        this.email = email;
        this.representativeFullName = representativeFullName;
    }

    public Long getDealerId() {
        return dealerId;
    }

    public void setDealerId(Long dealerId) {
        this.dealerId = dealerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRepresentativeFullName() {
        return representativeFullName;
    }

    public void setRepresentativeFullName(String representativeFullName) {
        this.representativeFullName = representativeFullName;
    }

    public Set<Customer> getCustomersList() {
        return customersList;
    }

    public void assignCustomer(Customer customer) {
        this.customersList.add(customer);
    }

    public void unassignCustomer(Customer customer) {
        this.customersList.remove(customer);
    }

}
