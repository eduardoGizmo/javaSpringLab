package com.codeclan.example.bookingservice.repositories.courseRepository;

import com.codeclan.example.bookingservice.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findCoursesByStarRating(int starRating);

    List<Course> findCourseByBookingsCustomerId(Long id);

}
