package com.evaluation.backend.item;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "item_location")
public class Location {
    protected Location() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long locationId;

    @Size(min = 1)
    private String state;

    private String address;

    private int phoneNumber;

    // Constructor

    public Location(String state, String address, int phoneNumber) {
        this.state = state;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    //Getters and Setters

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // toString()

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", state='" + state + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

}
