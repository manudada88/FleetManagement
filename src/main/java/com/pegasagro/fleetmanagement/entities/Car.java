package com.pegasagro.fleetmanagement.entities;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @NotBlank(message = "uniqueNumber name cannot be empty")
    @NotNull(message = "uniqueNumber name cannot be Null")
    @Pattern(regexp = "^[a-zA-Z0-9]{1,5}$",
            message = "Unique Number can be max 5 and Alphanumeric")
    private String uniqueNumber;

    @PastOrPresent(message = "Car Assembly date cannot be a future date")
    @NotNull(message = "assemblyDate name cannot be Null")
    private LocalDate assemblyDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @JsonIgnore
	private Customer owner;

    public Car() {
    }

    public Car(String uniqueNumber,
               LocalDate assemblyDate) {
        this.uniqueNumber = uniqueNumber;
        this.assemblyDate = assemblyDate;
    }

    public String getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(String uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    public LocalDate getAssemblyDate() {
        return assemblyDate;
    }

    public void setAssemblyDate(LocalDate assemblyDate) {
        this.assemblyDate = assemblyDate;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }
}
