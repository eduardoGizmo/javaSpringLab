package com.codeclan.example.bookingservice.repositories.bookingRepository;

import com.codeclan.example.bookingservice.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface BookingRepository extends JpaRepository<Booking, Long> {


    List<Booking> getBookingsByDate(String date);

}
