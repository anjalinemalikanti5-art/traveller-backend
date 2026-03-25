package com.example.smart_travel;

import jakarta.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String travellerName;
    private String busNumber;
    private int seatNumber;
    private String status;

    public Booking() {}

    public Long getId() { return id; }

    public String getTravellerName() { return travellerName; }
    public void setTravellerName(String travellerName) {
        this.travellerName = travellerName;
    }

    public String getBusNumber() { return busNumber; }
    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public int getSeatNumber() { return seatNumber; }
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) {
        this.status = status;
    }
}