package com.codeclan.example.bookingservice;

import com.codeclan.example.bookingservice.models.Booking;
import com.codeclan.example.bookingservice.models.Course;
import com.codeclan.example.bookingservice.models.Customer;
import com.codeclan.example.bookingservice.repositories.bookingRepository.BookingRepository;
import com.codeclan.example.bookingservice.repositories.courseRepository.CourseRepository;
import com.codeclan.example.bookingservice.repositories.customerRepository.CustomerRepository;
import org.hibernate.boot.jaxb.internal.JaxpSourceXmlSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class BookingserviceApplicationTests {


	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Test
	void contextLoads() {
	}


	@Test
	public void findCoursesByStarRating(){

		List<Course> found = courseRepository.findCoursesByStarRating(5);
		assertEquals("Data Analysis", found.get(0).getName());

	}

	@Test
	public void findCustomersByBookingsCourseId(){
		List<Customer> found = customerRepository.findCustomersByBookingsCourseId(1L);
		assertEquals("Marta", found.get(0).getName());
	}

	@Test
	public void findCourseByBookingsCustomerId(){
		List<Course> found = courseRepository.findCourseByBookingsCustomerId(1L);
		assertEquals(1, found.size());
		assertEquals("Data Analysis", found.get(0).getName());
	}

	@Test
	public void getBookingsByDate(){
		Customer customer1;
		List<Booking> found = bookingRepository.getBookingsByDate("12-03-20");
		assertEquals(1, found.get(0).getId());
	}



}
