package com.example.smart_travel;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/buses")
@CrossOrigin("*")
public class BusController {

    private final BusRepository busRepository;

    public BusController(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    // GET all buses
    @GetMapping
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    // POST add bus
    @PostMapping
    public Bus addBus(@RequestBody Bus bus) {
        return busRepository.save(bus);
    }

    // 🔥 SEARCH API
    @GetMapping("/search")
    public List<Bus> searchBus(
            @RequestParam String source,
            @RequestParam String destination) {

        return busRepository.findBySourceAndDestination(source, destination);
    }
}