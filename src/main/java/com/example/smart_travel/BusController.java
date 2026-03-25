package com.example.smart_travel;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/buses")
public class BusController {

    private final BusRepository busRepo;
    private final BookingRepository bookingRepo;

    public BusController(BusRepository busRepo, BookingRepository bookingRepo) {
        this.busRepo = busRepo;
        this.bookingRepo = bookingRepo;
    }

    @GetMapping
    public List<Bus> getAllBuses() {
        return busRepo.findAll();
    }

    @PostMapping
    public Bus addBus(@RequestBody Bus bus) {
        bus.setTotalSeats(20);
        return busRepo.save(bus);
    }

    @GetMapping("/search")
    public List<Bus> searchBus(@RequestParam String source,
                              @RequestParam String destination) {
        return busRepo.findBySourceIgnoreCaseAndDestinationIgnoreCase(source, destination);
    }

    @GetMapping("/availableSeats/{busNumber}")
    public int availableSeats(@PathVariable String busNumber) {

        Bus bus = busRepo.findByBusNumber(busNumber)
                .orElseThrow(() -> new RuntimeException("Bus not found"));

        List<Booking> bookings = bookingRepo
                .findByBusNumberAndStatus(busNumber, "BOOKED");

        return bus.getTotalSeats() - bookings.size();
    }
}