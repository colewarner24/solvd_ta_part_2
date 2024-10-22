package booking.dao.jdbc;

import booking.connection.DBConnection;
import booking.dao.SeatDAO;
import booking.exception.DAOException;
import booking.model.Seat;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import static booking.constant.ProjectConstant.*;

public class MySQLSeatDAO implements SeatDAO {

    static Logger logger = Logger.getLogger(DBConnection.class.getName());

    public void create(Seat seat) {
        Object[] values = {seat.getFlightId(), seat.getSeatNumber(), seat.getSeatClass(), seat.isAvailable()};
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SEATS_SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            for (int i = 0; i < values.length; i++) {
                statement.setObject(i + 1, values[i]);
            }
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    seat.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating seat failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            logger.severe("Failed to create seat: " + e);
            throw new DAOException(e);
        }
    }

    public Optional<Seat> findById(Integer seatId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEATS_FIND_BY_ID)) {
            preparedStatement.setInt(1, seatId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return Optional.of(mapRowToSeat(rs));
            }
        } catch (SQLException e) {
            logger.severe("Failed to find seat: " + e);
            throw new DAOException(e);
        }
        return Optional.empty();
    }

    public List<Seat> getAll() {
        List<Seat> seatList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(SEATS_FIND_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                seatList.add(mapRowToSeat(rs));
            }
        } catch (SQLException e) {
            logger.severe("Failed to get all seats: " + e);
            throw new DAOException(e);
        }
        return seatList;
    }

    public void update(Seat seat) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEATS_UPDATE)) {
            preparedStatement.setInt(1, seat.getFlightId());
            preparedStatement.setString(2, seat.getSeatNumber());
            preparedStatement.setString(3, seat.getSeatClass());
            preparedStatement.setBoolean(4, seat.isAvailable());
            preparedStatement.setInt(5, seat.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to update seat: " + e);
            throw new DAOException(e);
        }
    }

    public void delete(Integer seatId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(SEATS_DELETE)) {
            ps.setInt(1, seatId);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to delete seat: " + e);
            throw new DAOException(e);
        }
    }

    public void deleteAll() {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(SEATS_DELETE_ALL)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to delete all seats: " + e);
            throw new DAOException(e);
        }
    }

    private Seat mapRowToSeat(ResultSet rs) throws SQLException {
        return new Seat(
                rs.getInt("seat_id"),
                rs.getInt("flight_id"),
                rs.getString("seat_number"),
                rs.getString("class"),
                rs.getBoolean("available")
        );
    }
}
