package com.skully.skully.controller;

import com.skully.skully.model.Booking;
import com.skully.skully.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired  
    private BookingService bookingService;


    @PostMapping("/prototype")
    public ResponseEntity<?> bookPrototype(@RequestBody Booking booking) {
        Booking created = bookingService.create(booking);
        return ResponseEntity.created(URI.create("/api/bookings/" + created.getId())).body(created);
    }

    @GetMapping
    public ResponseEntity<?> list(@RequestParam(required = false) Long userId,
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int limit) {
        if (userId != null) {
            Page<Booking> p = bookingService.listForUser(userId, page, limit);
            return ResponseEntity.ok(p);
        }
        // not implementing global list; return empty
        return ResponseEntity.ok(java.util.List.of());
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<?> get(@PathVariable Long bookingId) {
        Booking b = bookingService.get(bookingId);
        if (b == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(b);
    }

    @PutMapping("/{bookingId}/cancel")
    public ResponseEntity<?> cancel(@PathVariable Long bookingId) {
        Booking b = bookingService.cancel(bookingId);
        if (b == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(b);
    }
}
