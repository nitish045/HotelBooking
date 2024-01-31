package com.tenzible.in.hotelbooking;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

import bookingController.BookingController;
import bookingModel.HotelBooking;

@SpringBootApplication
public class HotelbookingApplication {

	public static void main(String[] args) {
		
		 BookingController controller = new BookingController();
		SpringApplication.run(HotelbookingApplication.class, args);
		
		// Create a new booking
		HotelBooking newBooking = new HotelBooking(null, null, null, null, null);
        newBooking.setUserId("user123");
        newBooking.setHotelName("Example Hotel");
        newBooking.setCheckInDate("2024-02-01");
        newBooking.setCheckOutDate("2024-02-03");
        
        
        ResponseEntity<HotelBooking> bookingId = controller.createBooking(newBooking);
        System.out.println("New Booking ID: " + bookingId);
        
        // View the created booking
        ResponseEntity<HotelBooking> retrievedBooking = controller.viewBooking(bookingId);
        System.out.println("Retrieved Booking: " + retrievedBooking);

     // View all bookings
        ResponseEntity<Map<String, HotelBooking>> allBookings = controller.viewAllBookings();
        System.out.println("All Bookings: " + allBookings);
        
	}

}
