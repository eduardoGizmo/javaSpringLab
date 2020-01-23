package com.codeclan.example.bookingservice.controllers;

import com.codeclan.example.bookingservice.models.Booking;
import com.codeclan.example.bookingservice.models.Course;
import com.codeclan.example.bookingservice.repositories.bookingRepository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/dates/{date}")
    public List<Booking> getBookingsByDate(@PathVariable String date){
        return bookingRepository.getBookingsByDate(date);
    }

}
