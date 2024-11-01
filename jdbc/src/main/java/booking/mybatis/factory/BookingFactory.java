package booking.mybatis.factory;

import booking.model.Booking;

public class BookingFactory extends Factory {
    public Booking getBooking(Integer userId, Integer flightId, String bookingDate, Boolean checkedIn) {
        return new Booking(userId, flightId, flightId, bookingDate, checkedIn);
    }
}
