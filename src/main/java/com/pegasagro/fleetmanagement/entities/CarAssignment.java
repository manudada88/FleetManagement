package com.pegasagro.fleetmanagement.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.NumberFormat;

public class CarAssignment {

    @NotBlank(message = "carUniqueNumber name cannot be empty")
    @NotNull(message = "carUniqueNumber name cannot be Null")
    @Pattern(regexp = "^[a-zA-Z0-9]{1,5}$",
            message = "carUniqueNumber can be max 5 and Alphanumeric")
    public String carUniqueNumber;

    public long customerId;

    public String getCarUniqueNumber() {
        return carUniqueNumber;
    }

    public void setCarUniqueNumber(String carUniqueNumber) {
        this.carUniqueNumber = carUniqueNumber;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
