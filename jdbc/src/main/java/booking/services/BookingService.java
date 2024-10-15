package booking.services;

import booking.dao.BookingDAO;
import booking.dao.jdbc.MySQLBookingsDAO;
import booking.exception.DAOException;
import booking.factory.DAOFactory;
import booking.model.Booking;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BookingService {

    private final BookingDAO bookingDAO;

    public BookingService(DAOFactory daoFactory) throws DAOException {
        this.bookingDAO = daoFactory.getBookingDAO();
    }

    public BookingService() {
        this.bookingDAO = new MySQLBookingsDAO();
    }

    public void createBooking(Booking booking) throws SQLException {
        bookingDAO.create(booking);
    }

    public Optional<Booking> getBooking(Integer id) {
        return bookingDAO.findById(id);
    }

    public void updateBooking(Booking booking) throws SQLException {
        bookingDAO.update(booking);
    }

    public void deleteBooking(Integer bookingId) {
        bookingDAO.delete(bookingId);
    }

    public List<Booking> getAllBookings() {
        return bookingDAO.getAll();
    }

    public void deleteAllBookings() {
        bookingDAO.deleteAll();
    }
}
