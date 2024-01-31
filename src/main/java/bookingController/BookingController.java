package bookingController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bookingModel.HotelBooking;


@RestController
@RequestMapping("/bookings")
public class BookingController {

	private Map<String,HotelBooking> bookings;
	
	public BookingController() {
        this.bookings = new HashMap<>();
    }
	
	
	// Endpoint for creating a new booking
	
	@PostMapping("/create")
    public ResponseEntity<String> createBooking(HotelBooking booking) {
        String bookingId = generateBookingId(); // You can implement this method
        booking.setBookingId(bookingId);
        bookings.put(bookingId, booking);
        return ResponseEntity.status(HttpStatus.CREATED).body("Booking created with ID: " + bookingId);
    }
    
    // Endpoint for viewing a specific booking
	
	@GetMapping("/vew/{bookingId}")
    public ResponseEntity<HotelBooking> viewBooking(String bookingId) {
		HotelBooking booking = bookings.get(bookingId);
        if (booking != null) {
            return ResponseEntity.ok(booking);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
    // Endpoint for viewing all bookings
	
	@GetMapping("view/all")
    public ResponseEntity<Map<String, HotelBooking>> viewAllBookings() {
		return ResponseEntity.ok(bookings);
    }


	private String generateBookingId() {
		// TODO Auto-generated method stub
		return "BID_" + System.currentTimeMillis();
	}
}
