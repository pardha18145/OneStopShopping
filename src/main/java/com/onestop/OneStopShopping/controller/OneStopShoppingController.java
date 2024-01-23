package com.onestop.OneStopShopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onestop.OneStopShopping.model.Booking;
import com.onestop.OneStopShopping.repository.BookingRepository;

@RestController
@RequestMapping("/api/bookings")
public class OneStopShoppingController {
    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
