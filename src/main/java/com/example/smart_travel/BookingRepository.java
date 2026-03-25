package com.example.smart_travel;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByBusNumberAndStatus(String busNumber, String status);

    List<Booking> findByTravellerNameContaining(String travellerName);

    List<Booking> findByDestinationContaining(String destination);
}