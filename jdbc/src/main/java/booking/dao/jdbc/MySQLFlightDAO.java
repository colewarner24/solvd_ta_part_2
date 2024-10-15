package booking.dao.jdbc;

import booking.connection.DBConnection;
import booking.dao.FlightDAO;
import booking.exception.DAOException;
import booking.model.Flight;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import booking.constant.ProjectConstant;

import static booking.constant.ProjectConstant.FLIGHTS_SQL_INSERT;
import static booking.util.PrepareStatement.prepareStatement;

public class MySQLFlightDAO implements FlightDAO {

    static Logger logger = Logger.getLogger(DBConnection.class.getName());

    public List<Flight> getAll() {
        List<Flight> flights = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = prepareStatement(connection, ProjectConstant.FLIGHTS_FIND_ALL, false)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                flights.add(mapRowToFlight(rs));
            }

        } catch (SQLException e) {
            logger.severe("Failed to get all flights: " + e);
            throw new DAOException(e);
        }
        return flights;
    }

    public Optional<Flight> findById(Integer flightId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = prepareStatement(connection, ProjectConstant.FLIGHTS_FIND_BY_ID, false)) {

            preparedStatement.setInt(1, flightId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return Optional.of(mapRowToFlight(rs));
            }
        } catch (SQLException e) {
            logger.severe("Failed to find flight: " + e);
            throw new DAOException(e);
        }
        return Optional.empty();
    }

    public void create(Flight flight) {
        Object[] values = {flight.getAirlineId(), flight.getDepartureAirportId(), flight.getArrivalAirportId(), flight.getDepartureTime(), flight.getFlightNumber(), flight.getArrivalTime()};
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement statement = prepareStatement(connection, FLIGHTS_SQL_INSERT, true, values);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    flight.setFlightId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating flight failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            logger.severe("Failed to create flight: " + e);
            throw new DAOException(e);
        }
    }

    public void update(Flight flight) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = prepareStatement(connection, ProjectConstant.FLIGHTS_UPDATE, false)) {

            preparedStatement.setInt(1, flight.getAirlineId());
            preparedStatement.setInt(2, flight.getDepartureAirportId());
            preparedStatement.setInt(3, flight.getArrivalAirportId());
            preparedStatement.setString(4, flight.getDepartureTime());
            preparedStatement.setString(5, flight.getFlightNumber());
            preparedStatement.setString(6, flight.getArrivalTime());
            preparedStatement.setInt(7, flight.getFlightId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.severe("Failed to update flight: " + e);
            throw new DAOException(e);
        }
    }

    public void delete(Integer flightId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = prepareStatement(connection, ProjectConstant.FLIGHTS_DELETE, false)) {

            ps.setInt(1, flightId);
            ps.executeUpdate();

        } catch (SQLException e) {
            logger.severe("Failed to delete flight: " + e);
            throw new DAOException(e);
        }
    }

    public void deleteAll() {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = prepareStatement(connection, ProjectConstant.FLIGHTS_DELETE_ALL, false)) {

            ps.executeUpdate();

        } catch (SQLException e) {
            logger.severe("Failed to delete all flights: " + e);
            throw new DAOException(e);
        }
    }

    private Flight mapRowToFlight(ResultSet rs) throws SQLException {
        return new Flight(
                rs.getInt("flight_id"),
                rs.getInt("airline_id"),
                rs.getInt("departure_airport_id"),
                rs.getInt("arrival_airport_id"),
                rs.getString("departure_time"),
                rs.getString("flight_number"),
                rs.getString("arrival_time")
        );
    }
}
