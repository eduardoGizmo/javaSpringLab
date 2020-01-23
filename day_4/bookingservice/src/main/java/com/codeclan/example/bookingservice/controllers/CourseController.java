package com.codeclan.example.bookingservice.controllers;

import com.codeclan.example.bookingservice.models.Course;
import com.codeclan.example.bookingservice.models.Customer;
import com.codeclan.example.bookingservice.repositories.courseRepository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {


    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/ratings/{starRating}")
    public List<Course> findCoursesByStarRating(@PathVariable int starRating) {
        return courseRepository.findCoursesByStarRating(starRating);
    }


    @GetMapping(value = "/customers/{id}")
    public List<Course> findCourseByBookingsCustomerId(@PathVariable Long id){
        return courseRepository.findCourseByBookingsCustomerId(id);
    }


}
