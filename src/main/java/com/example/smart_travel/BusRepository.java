package com.example.smart_travel;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BusRepository extends JpaRepository<Bus, Long> {

    // 🔥 ADD THIS
    List<Bus> findBySourceAndDestination(String source, String destination);
}