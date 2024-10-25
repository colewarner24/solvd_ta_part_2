package mybatis;

import booking.model.Booking;
import booking.mybatis.services.BookingService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BookingTest {

    private Booking booking1;
    private BookingService bookingService;

    @Before
    public void setUp() {
        bookingService = new BookingService();
        booking1 = new Booking(50, 5, "2024-10-25T10:00:00", true);
        bookingService.create(booking1);
    }

    @Test
    public void testCreateBooking() {
        Booking db_booking = bookingService.findById(booking1.getId());
        assert booking1.equals(db_booking);
    }

    @Test
    public void updateBooking() {
        Booking bookingUpdate = new Booking(booking1.getId(), booking1.getUserId(), booking1.getFlightId(), "2024-10-26T15:30:00", false);
        bookingService.update(bookingUpdate);
        Booking db_booking = bookingService.findById(booking1.getId());
        assert bookingUpdate.equals(db_booking);
    }

    @Test
    public void deleteBooking() {
        bookingService.delete(booking1.getId());
        Booking db_booking = bookingService.findById(booking1.getId());
        assert db_booking == null;
    }

    @After
    public void tearDown() {
        bookingService.delete(booking1.getId());
    }
}
