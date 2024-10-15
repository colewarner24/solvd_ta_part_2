package booking.dao.jdbc;

import booking.connection.DBConnection;
import booking.dao.PassengerSeatDAO;
import booking.exception.DAOException;
import booking.model.PassengerSeat;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import static booking.constant.ProjectConstant.*;

public class MySQLPassengerSeatDAO implements PassengerSeatDAO {

    static Logger logger = Logger.getLogger(DBConnection.class.getName());

    public void create(PassengerSeat passengerSeat) {
        Object[] values = {passengerSeat.getPassengerId(), passengerSeat.getSeatNumber()};
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(PASSENGER_SEATS_SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            for (int i = 0; i < values.length; i++) {
                statement.setObject(i + 1, values[i]);
            }
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    passengerSeat.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating passenger seat failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            logger.severe("Failed to create passenger seat: " + e);
            throw new DAOException(e);
        }
    }

    public Optional<PassengerSeat> findById(Integer passengerSeatId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(PASSENGER_SEATS_FIND_BY_ID)) {
            preparedStatement.setInt(1, passengerSeatId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return Optional.of(mapRowToPassengerSeat(rs));
            }
        } catch (SQLException e) {
            logger.severe("Failed to find passenger seat: " + e);
            throw new DAOException(e);
        }
        return Optional.empty();
    }

    public List<PassengerSeat> getAll() {
        List<PassengerSeat> passengerSeatList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(PASSENGER_SEATS_FIND_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                passengerSeatList.add(mapRowToPassengerSeat(rs));
            }
        } catch (SQLException e) {
            logger.severe("Failed to get all passenger seats: " + e);
            throw new DAOException(e);
        }
        return passengerSeatList;
    }

    public void update(PassengerSeat passengerSeat) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(PASSENGER_SEATS_UPDATE)) {
            preparedStatement.setInt(1, passengerSeat.getPassengerId());
            preparedStatement.setString(2, passengerSeat.getSeatNumber());
            preparedStatement.setInt(3, passengerSeat.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to update passenger seat: " + e);
            throw new DAOException(e);
        }
    }

    public void delete(Integer passengerSeatId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(PASSENGER_SEATS_DELETE)) {
            ps.setInt(1, passengerSeatId);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to delete passenger seat: " + e);
            throw new DAOException(e);
        }
    }

    public void deleteAll() {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(PASSENGER_SEATS_DELETE_ALL)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to delete all passenger seats: " + e);
            throw new DAOException(e);
        }
    }

    private PassengerSeat mapRowToPassengerSeat(ResultSet rs) throws SQLException {
        return new PassengerSeat(
                rs.getInt("passenger_seat_id"),
                rs.getInt("passenger_id"),
                rs.getString("seat_number")
        );
    }
}
