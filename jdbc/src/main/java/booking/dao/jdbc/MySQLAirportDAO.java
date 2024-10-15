package booking.dao.jdbc;

import booking.connection.DBConnection;
import booking.dao.AirportDAO;
import booking.exception.DAOException;
import booking.model.Airport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static booking.constant.ProjectConstant.*;
import static booking.util.PrepareStatement.prepareStatement;

public class MySQLAirportDAO implements AirportDAO {

    static Logger logger = Logger.getLogger(DBConnection.class.getName());

    @Override
    public void insert(Airport airport) {
        Object[] values = {airport.getName(), airport.getCity(), airport.getCode(), airport.getCountry()};
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = prepareStatement(connection, AIRPORTS_SQL_INSERT, true, values)) {
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    airport.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating airport failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            logger.severe("Failed to insert airport: " + e);
            throw new DAOException(e);
        }
    }

    @Override
    public Optional<Airport> findById(int id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = prepareStatement(connection, AIRPORTS_FIND_BY_ID, false)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(mapRowToAirport(resultSet));
            }
        } catch (SQLException e) {
            logger.severe("Failed to find airport: " + e);
            throw new DAOException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<Airport> findAll() {
        List<Airport> airports = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = prepareStatement(connection, AIRPORTS_FIND_ALL, false);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                airports.add(mapRowToAirport(resultSet));
            }
        } catch (SQLException e) {
            logger.severe("Failed to find all airports: " + e);
            throw new DAOException(e);
        }
        return airports;
    }

    @Override
    public void update(Airport airport) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = prepareStatement(connection, AIRPORTS_UPDATE, false)) {
            statement.setString(1, airport.getName());
            statement.setString(2, airport.getCity());
            statement.setString(3, airport.getCode());
            statement.setString(4, airport.getCountry());
            statement.setInt(5, airport.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to update airport: " + e);
            throw new DAOException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = prepareStatement(connection, AIRPORTS_DELETE, false)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to delete airport: " + e);
            throw new DAOException(e);
        }
    }

    @Override
    public void deleteAll() {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = prepareStatement(connection, AIRPORTS_DELETE_ALL, false)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to delete all airports: " + e);
            throw new DAOException(e);
        }
    }

    private Airport mapRowToAirport(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("airport_id");
        String name = resultSet.getString("airport_name");
        String city = resultSet.getString("airport_city");
        String code = resultSet.getString("airport_code");
        String country = resultSet.getString("airport_country");
        return new Airport(id, name, city, code, country);
    }
}
