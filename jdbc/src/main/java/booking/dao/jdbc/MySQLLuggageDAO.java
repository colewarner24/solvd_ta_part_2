package booking.dao.jdbc;

import booking.connection.DBConnection;
import booking.dao.LuggageDAO;
import booking.exception.DAOException;
import booking.model.Luggage;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import static booking.constant.ProjectConstant.*;

public class MySQLLuggageDAO implements LuggageDAO {

    static Logger logger = Logger.getLogger(DBConnection.class.getName());

    public void create(Luggage luggage) {
        Object[] values = {luggage.getPassengerId(), luggage.getLuggageType()};
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(LUGGAGE_SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            for (int i = 0; i < values.length; i++) {
                statement.setObject(i + 1, values[i]);
            }
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    luggage.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating luggage failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            logger.severe("Failed to create luggage: " + e);
            throw new DAOException(e);
        }
    }

    public Optional<Luggage> findById(Integer luggageId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(LUGGAGE_FIND_BY_ID)) {
            preparedStatement.setInt(1, luggageId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return Optional.of(mapRowToLuggage(rs));
            }
        } catch (SQLException e) {
            logger.severe("Failed to find luggage: " + e);
            throw new DAOException(e);
        }
        return Optional.empty();
    }

    public List<Luggage> getAll() {
        List<Luggage> luggageList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(LUGGAGE_FIND_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                luggageList.add(mapRowToLuggage(rs));
            }
        } catch (SQLException e) {
            logger.severe("Failed to get all luggage: " + e);
            throw new DAOException(e);
        }
        return luggageList;
    }

    public void update(Luggage luggage) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(LUGGAGE_UPDATE)) {
            preparedStatement.setInt(1, luggage.getPassengerId());
            preparedStatement.setString(2, luggage.getLuggageType());
            preparedStatement.setInt(3, luggage.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to update luggage: " + e);
            throw new DAOException(e);
        }
    }

    public void delete(Integer luggageId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(LUGGAGE_DELETE)) {
            ps.setInt(1, luggageId);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to delete luggage: " + e);
            throw new DAOException(e);
        }
    }

    public void deleteAll() {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(LUGGAGE_DELETE_ALL)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to delete all luggage: " + e);
            throw new DAOException(e);
        }
    }

    private Luggage mapRowToLuggage(ResultSet rs) throws SQLException {
        return new Luggage(
                rs.getInt("luggage_id"),
                rs.getInt("passenger_id"),
                rs.getString("luggage_type")
        );
    }
}
