package com.example.smart_travel;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String travellerName;
    private String busNumber;
    private int seatNumber;
    private int totalSeats;
    private String destination;
    private String status;
    private String mobile;
    private LocalDate travelDate;

    public Booking() {}

    // ==================== GETTERS ====================
    public Long getId() { return id; }
    public String getTravellerName() { return travellerName; }
    public String getBusNumber() { return busNumber; }
    public int getSeatNumber() { return seatNumber; }
    public int getTotalSeats() { return totalSeats; }
    public String getDestination() { return destination; } // ✅ must exist
    public String getStatus() { return status; }
    public String getMobile() { return mobile; }
    public LocalDate getTravelDate() { return travelDate; }

    // ==================== SETTERS ====================
    public void setId(Long id) { this.id = id; }
    public void setTravellerName(String travellerName) { this.travellerName = travellerName; }
    public void setBusNumber(String busNumber) { this.busNumber = busNumber; }
    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }
    public void setTotalSeats(int totalSeats) { this.totalSeats = totalSeats; }
    public void setDestination(String destination) { this.destination = destination; } // ✅ must exist
    public void setStatus(String status) { this.status = status; }
    public void setMobile(String mobile) { this.mobile = mobile; }
    public void setTravelDate(LocalDate travelDate) { this.travelDate = travelDate; }
}