package com.example.smart_travel;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingRepository bookingRepo;

    public BookingController(BookingRepository bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    @PostMapping
    public Booking bookSeat(@RequestBody Booking booking) {

        boolean alreadyBooked = bookingRepo
                .findByBusNumberAndStatus(booking.getBusNumber(), "BOOKED")
                .stream()
                .anyMatch(b -> b.getSeatNumber() == booking.getSeatNumber());

        if (alreadyBooked) {
            throw new RuntimeException("Seat already booked!");
        }

        booking.setStatus("BOOKED");
        return bookingRepo.save(booking);
    }

    @PutMapping("/cancel/{id}")
    public Booking cancelBooking(@PathVariable Long id) {
        Booking booking = bookingRepo.findById(id).orElseThrow();
        booking.setStatus("CANCELLED");
        return bookingRepo.save(booking);
    }
}