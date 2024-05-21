package com.pegasagro.fleetmanagement.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	
	@NotBlank(message = "customer name cannot be empty")
	@NotNull(message = "customer name cannot be Null")
	private String fullName;

	@NotBlank(message = "phoneNumber cannot be blank")
	private String phoneNumber;
	
	@Email(message = "EmailId is not valid")
	@NotBlank(message = "EmailId name cannot be blank")
	private String email;

	@OneToMany(mappedBy = "owner")
	private Set<Car> carsOwned = new HashSet<>();

	@ManyToMany
	@JsonIgnore
	private Set<Dealer> dealersAssigned = new HashSet<>();
	
	public Customer() {
	}

	public Customer(Long customerId,
					String fullName,
					String phoneNumber,
					String email) {
		this.customerId = customerId;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Set<Car> getCarsOwned() {
		return carsOwned;
	}

	public void addCar(Car car) {
		this.carsOwned.add(car);
	}
	
	public void removeCar(Car car) {
		this.carsOwned.remove(car);
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void assignDealer(Dealer dealer) {
		this.dealersAssigned.add(dealer);
	}

	public void unassignCustomer(Dealer dealer) {
		this.dealersAssigned.remove(dealer);
	}

	public void setDealersAssigned(Set<Dealer> dealersAssigned) {
		this.dealersAssigned = dealersAssigned;
	}
}
