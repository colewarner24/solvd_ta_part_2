package booking.dao.jdbc;

import booking.connection.DBConnection;
import booking.dao.PassengerDAO;
import booking.exception.DAOException;
import booking.model.Passenger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import static booking.constant.ProjectConstant.*;

public class MySQLPassengerDAO implements PassengerDAO {

    static Logger logger = Logger.getLogger(DBConnection.class.getName());

    public void create(Passenger passenger) {
        Object[] values = {passenger.getBookingId(), passenger.getUserId()};
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(PASSENGERS_SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            for (int i = 0; i < values.length; i++) {
                statement.setObject(i + 1, values[i]);
            }
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    passenger.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating passenger failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            logger.severe("Failed to create passenger: " + e);
            throw new DAOException(e);
        }
    }

    public Optional<Passenger> findById(Integer passengerId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(PASSENGERS_FIND_BY_ID)) {
            preparedStatement.setInt(1, passengerId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return Optional.of(mapRowToPassenger(rs));
            }
        } catch (SQLException e) {
            logger.severe("Failed to find passenger: " + e);
            throw new DAOException(e);
        }
        return Optional.empty();
    }

    public List<Passenger> getAll() {
        List<Passenger> passengerList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(PASSENGERS_FIND_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                passengerList.add(mapRowToPassenger(rs));
            }
        } catch (SQLException e) {
            logger.severe("Failed to get all passengers: " + e);
            throw new DAOException(e);
        }
        return passengerList;
    }

    public void update(Passenger passenger) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(PASSENGERS_UPDATE)) {
            preparedStatement.setInt(1, passenger.getBookingId());
            preparedStatement.setInt(2, passenger.getUserId());
            preparedStatement.setInt(3, passenger.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to update passenger: " + e);
            throw new DAOException(e);
        }
    }

    public void delete(Integer passengerId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(PASSENGERS_DELETE)) {
            ps.setInt(1, passengerId);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to delete passenger: " + e);
            throw new DAOException(e);
        }
    }

    public void deleteAll() {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(PASSENGERS_DELETE_ALL)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to delete all passengers: " + e);
            throw new DAOException(e);
        }
    }

    private Passenger mapRowToPassenger(ResultSet rs) throws SQLException {
        return new Passenger(
                rs.getInt("passenger_id"),
                rs.getInt("booking_id"),
                rs.getInt("user_id")
        );
    }
}
