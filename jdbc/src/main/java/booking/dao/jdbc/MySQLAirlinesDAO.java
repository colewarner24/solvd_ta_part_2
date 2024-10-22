package booking.dao.jdbc;

import booking.connection.DBConnection;
import booking.dao.AirlinesDAO;
import booking.exception.DAOException;
import booking.model.Airline;
import booking.constant.ProjectConstant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static booking.util.PrepareStatement.prepareStatement;

public class MySQLAirlinesDAO implements AirlinesDAO {

    static Logger logger = Logger.getLogger(DBConnection.class.getName());

    @Override
    public List<Airline> getAll() {
        List<Airline> airlines = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = prepareStatement(connection, ProjectConstant.AIRLINES_FIND_ALL, false)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Airline airline = new Airline(rs.getInt("airline_id"),
                        rs.getString("airline_name"));
                airlines.add(airline);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airlines;
    }

    @Override
    public Airline findById(Integer airlineId) {
        Airline airline = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = prepareStatement(connection, ProjectConstant.AIRLINES_FIND_BY_ID, false, airlineId)) {

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                airline = new Airline(rs.getInt("airline_id"),
                        rs.getString("airline_name"));
            }

        } catch (SQLException e) {
            logger.severe("Failed to find airline: " + e);
            throw new DAOException(e);
        }
        if (airline == null) {
            logger.severe("Airline not found");
            throw new DAOException("Airline not found");
        }
        return airline;
    }

    @Override
    public void create(Airline airline) {
        Object[] values = {airline.getName()};
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement statement = prepareStatement(connection, ProjectConstant.AIRLINES_SQL_INSERT, true, values);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    airline.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating airline failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            logger.severe("Failed to create airline: " + e);
            throw new DAOException(e);
        }
    }

    @Override
    public void update(Airline airline) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = prepareStatement(connection, ProjectConstant.AIRLINES_UPDATE, false)) {

            ps.setString(1, airline.getName());
            ps.setInt(2, airline.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            logger.severe("Failed to update airline: " + e);
            throw new DAOException(e);
        }
    }

    @Override
    public void delete(Integer airlineId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = prepareStatement(connection, ProjectConstant.AIRLINES_DELETE, false)) {

            ps.setInt(1, airlineId);
            ps.executeUpdate();

        } catch (SQLException e) {
            logger.severe("Failed to delete airline: " + e);
            throw new DAOException(e);
        }
    }

    @Override
    public void deleteAll() {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = prepareStatement(connection, ProjectConstant.AIRLINES_DELETE_ALL, false)) {

            ps.executeUpdate();

        } catch (SQLException e) {
            logger.severe("Failed to delete all airlines: " + e);
            throw new DAOException(e);
        }
    }
}
