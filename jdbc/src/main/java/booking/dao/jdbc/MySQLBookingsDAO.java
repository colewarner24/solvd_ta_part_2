package booking.dao.jdbc;

import booking.connection.DBConnection;
import booking.dao.BookingDAO;
import booking.exception.DAOException;
import booking.model.Booking;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import static booking.constant.ProjectConstant.*;

public class MySQLBookingsDAO implements BookingDAO {

    static Logger logger = Logger.getLogger(DBConnection.class.getName());

    public void create(Booking booking) {
        Object[] values = {booking.getUserId(), booking.getFlightId(), booking.getBookingDate(), booking.getCheckedIn()};
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(BOOKINGS_SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            for (int i = 0; i < values.length; i++) {
                statement.setObject(i + 1, values[i]);
            }
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    booking.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating booking failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            logger.severe("Failed to create booking: " + e);
            throw new DAOException(e);
        }
    }

    public Optional<Booking> findById(Integer bookingId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(BOOKINGS_FIND_BY_ID)) {
            preparedStatement.setInt(1, bookingId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return Optional.of(mapRowToBooking(rs));
            }
        } catch (SQLException e) {
            logger.severe("Failed to find booking: " + e);
            throw new DAOException(e);
        }
        return Optional.empty();
    }

    public List<Booking> getAll() {
        List<Booking> bookings = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(BOOKINGS_FIND_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                bookings.add(mapRowToBooking(rs));
            }
        } catch (SQLException e) {
            logger.severe("Failed to get all bookings: " + e);
            throw new DAOException(e);
        }
        return bookings;
    }

    public void update(Booking booking) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(BOOKINGS_UPDATE)) {
            preparedStatement.setInt(1, booking.getUserId());
            preparedStatement.setInt(2, booking.getFlightId());
            preparedStatement.setString(3, booking.getBookingDate());
            preparedStatement.setBoolean(4, booking.getCheckedIn());
            preparedStatement.setInt(5, booking.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to update booking: " + e);
            throw new DAOException(e);
        }
    }

    public void delete(Integer bookingId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(BOOKINGS_DELETE)) {
            ps.setInt(1, bookingId);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to delete booking: " + e);
            throw new DAOException(e);
        }
    }

    public void deleteAll() {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(BOOKINGS_DELETE_ALL)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to delete all bookings: " + e);
            throw new DAOException(e);
        }
    }

    private Booking mapRowToBooking(ResultSet rs) throws SQLException {
        return new Booking(
                rs.getInt("booking_id"),
                rs.getInt("user_id"),
                rs.getInt("flight_id"),
                rs.getString("booking_date"),
                rs.getBoolean("checked_in")
        );
    }
}