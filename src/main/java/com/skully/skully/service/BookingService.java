package com.skully.skully.service;

import com.skully.skully.model.Booking;
import com.skully.skully.repository.BookingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BookingService {


    @Autowired
    private BookingRepository bookingRepository;


    public Booking create(Booking b) {
        b.setStatus("booked");
        return bookingRepository.save(b);
    }

    public Page<Booking> listForUser(Long userId, int page, int limit) {
        return bookingRepository.findByUserId(userId, PageRequest.of(page, limit));
    }

    public Booking get(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public Booking cancel(Long id) {
        return bookingRepository.findById(id).map(b -> {
            b.setStatus("cancelled");
            return bookingRepository.save(b);
        }).orElse(null);
    }
}
