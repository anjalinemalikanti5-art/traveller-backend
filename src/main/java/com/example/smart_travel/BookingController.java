package com.example.smart_travel;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin("*")
public class BookingController {

    private final BookingRepository repo;

    public BookingController(BookingRepository repo) {
        this.repo = repo;
    }

    // GET all bookings
    @GetMapping
    public List<Booking> getAll() {
        return repo.findAll();
    }

    // POST book seat
    @PostMapping
    public Booking book(@RequestBody Booking booking) {
        booking.setStatus("BOOKED"); // 🔥 important
        return repo.save(booking);
    }

    // CANCEL booking
    @PutMapping("/cancel/{id}")
    public Booking cancel(@PathVariable Long id) {
        Booking b = repo.findById(id).orElseThrow();
        b.setStatus("CANCELLED");
        return repo.save(b);
    }
}