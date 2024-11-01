package booking.mybatis.view;

import booking.model.Booking;

import java.util.List;

public class BookingView {

    public static void displayBookings(List<Booking> bookings) {
        System.out.println("---- Bookings ----");
        for (Booking booking : bookings) {
            displayBooking(booking);
            System.out.println("-----------------");
        }
    }

    public static void displayBooking(Booking booking) {
        System.out.println("Booking ID: " + booking.getId());
        System.out.println("User ID: " + booking.getUserId());
        System.out.println("Flight ID: " + booking.getFlightId());
        System.out.println("Booking Date: " + booking.getBookingDate());
        System.out.println("Checked In: " + (booking.getCheckedIn() ? "Yes" : "No"));
    }

}
