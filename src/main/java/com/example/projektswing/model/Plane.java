package com.example.projektswing.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "planes")
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 6, max = 7, message = "Registration code must be 7 characters long.")
    private String registrationCode;

    @Min(value = 500, message = "Minimum fuel capacity is 500 liters.")
    @Max(value = 200000, message = "Maximum fuel capacity is 200,000 liters.")
    private float fuelCapacity;

    @Min(value = 2, message = "A plane must have at least 2 seats.")
    @Max(value = 850, message = "Maximum number of seats is 850.")
    private int numberOfSeats;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "The service date must be today or in the future.")
    private Date nextServiceDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }

    public float getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(float fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Date getNextServiceDate() {
        return nextServiceDate;
    }

    public void setNextServiceDate(Date nextServiceDate) {
        this.nextServiceDate = nextServiceDate;
    }

}
