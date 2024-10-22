package booking.dao.jdbc;

import booking.connection.DBConnection;
import booking.dao.FlightPricingDAO;
import booking.exception.DAOException;
import booking.model.FlightPricing;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import static booking.constant.ProjectConstant.*;

public class MySQLFlightPricingDAO implements FlightPricingDAO {

    static Logger logger = Logger.getLogger(DBConnection.class.getName());

    public void create(FlightPricing flightPricing) {
        Object[] values = {flightPricing.getFlightId(), flightPricing.getPrice(), flightPricing.getFlightClass()};
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(FLIGHT_PRICING_SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            for (int i = 0; i < values.length; i++) {
                statement.setObject(i + 1, values[i]);
            }
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    flightPricing.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating flight pricing failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            logger.severe("Failed to create flight pricing: " + e);
            throw new DAOException(e);
        }
    }

    public Optional<FlightPricing> findById(Integer flightPricingId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FLIGHT_PRICING_FIND_BY_ID)) {
            preparedStatement.setInt(1, flightPricingId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return Optional.of(mapRowToFlightPricing(rs));
            }
        } catch (SQLException e) {
            logger.severe("Failed to find flight pricing: " + e);
            throw new DAOException(e);
        }
        return Optional.empty();
    }

    public List<FlightPricing> getAll() {
        List<FlightPricing> flightPricings = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(FLIGHT_PRICING_FIND_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                flightPricings.add(mapRowToFlightPricing(rs));
            }
        } catch (SQLException e) {
            logger.severe("Failed to get all flight pricings: " + e);
            throw new DAOException(e);
        }
        return flightPricings;
    }

    public void update(FlightPricing flightPricing) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FLIGHT_PRICING_UPDATE)) {
            preparedStatement.setInt(1, flightPricing.getFlightId());
            preparedStatement.setDouble(2, flightPricing.getPrice());
            preparedStatement.setString(3, flightPricing.getFlightClass());
            preparedStatement.setInt(4, flightPricing.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to update flight pricing: " + e);
            throw new DAOException(e);
        }
    }

    public void delete(Integer flightPricingId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(FLIGHT_PRICING_DELETE)) {
            ps.setInt(1, flightPricingId);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to delete flight pricing: " + e);
            throw new DAOException(e);
        }
    }

    public void deleteAll() {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(FLIGHT_PRICING_DELETE_ALL)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to delete all flight pricings: " + e);
            throw new DAOException(e);
        }
    }

    private FlightPricing mapRowToFlightPricing(ResultSet rs) throws SQLException {
        return new FlightPricing(
                rs.getInt("flight_pricing_id"),
                rs.getInt("flight_id"),
                rs.getDouble("price"),
                rs.getString("class")
        );
    }
}
