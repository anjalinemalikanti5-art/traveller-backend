package com.example.smart_travel;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface BusRepository extends JpaRepository<Bus, Long> {

    List<Bus> findBySourceIgnoreCaseAndDestinationIgnoreCase(String source, String destination);

    Optional<Bus> findByBusNumber(String busNumber);
}