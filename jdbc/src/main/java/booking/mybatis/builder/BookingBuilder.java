package booking.mybatis.builder;

import booking.model.Booking;
import booking.model.Flight;
import booking.model.User;
import booking.mybatis.services.BookingService;
import booking.mybatis.services.FlightService;
import booking.mybatis.services.UserService;


public class BookingBuilder {
    public Booking buildBooking(User user, Flight flight, int seatNumber, String bookingClass, Boolean bookingStatus) {
        UserService userService = new UserService();
        FlightService flightService = new FlightService();
        BookingService bookingService = new BookingService();

        userService.create(user);
        flightService.create(flight);

        Booking booking = new Booking(user.getId(), flight.getId(), seatNumber, bookingClass, bookingStatus);
        bookingService.create(booking);
        return booking;
    }
}
