package com.codeclan.example.bookingservice.components;

import com.codeclan.example.bookingservice.models.Booking;
import com.codeclan.example.bookingservice.models.Course;
import com.codeclan.example.bookingservice.models.Customer;
import com.codeclan.example.bookingservice.repositories.bookingRepository.BookingRepository;
import com.codeclan.example.bookingservice.repositories.courseRepository.CourseRepository;
import com.codeclan.example.bookingservice.repositories.customerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader(){

    }


    public void run(ApplicationArguments args){

        Course course1 = new Course("Data Analysis", "Edinburgh", 5);
        courseRepository.save(course1);
        Course course2 = new Course("Software Development ", "Edinburgh", 4);
        courseRepository.save(course2);


        Customer customer1 = new Customer("Marta","Edinburgh", 23);
        customerRepository.save(customer1);
        Customer customer2 = new Customer("Eduardo","Edinburgh", 34);
        customerRepository.save(customer2);


        Booking booking1 = new Booking("12-03-20", customer1, course1 );
        bookingRepository.save(booking1);
        Booking booking2 = new Booking("02-01-19", customer2, course2 );
        bookingRepository.save(booking2);

        customer1.addBooking(booking1);
        customerRepository.save(customer1);

        customer2.addBooking(booking2);
        customerRepository.save(customer2);

        course1.addBooking(booking1);
        courseRepository.save(course1);

        course2.addBooking(booking2);
        courseRepository.save(course2);



    }



}
