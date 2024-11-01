package booking.mybatis.controller;

import booking.model.Booking;
import booking.mybatis.services.BookingService;
import booking.mybatis.view.BookingView;

import java.util.List;

public class BookingController implements Controller<Booking> {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public void displayAll() {
        List<Booking> bookings = bookingService.getAll();
        BookingView.displayBookings(bookings);
    }

    public void create(Booking booking) {
        bookingService.create(booking);
        System.out.println("Booking " + booking.getId() + " created successfully.");
    }

    public void delete(int bookingId) {
        bookingService.delete(bookingId);
        System.out.println("Booking: " + bookingId + " deleted successfully.");
    }

    public void update(Booking booking) {
        bookingService.update(booking);
        System.out.println("Booking: " + booking.getId() + " updated successfully.");
    }

    public Booking findById(int bookingId) {
        return bookingService.findById(bookingId);
    }
}
