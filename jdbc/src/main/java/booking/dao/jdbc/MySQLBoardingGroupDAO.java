package booking.dao.jdbc;

import booking.connection.DBConnection;
import booking.dao.BoardingGroupDAO;
import booking.exception.DAOException;
import booking.model.BoardingGroup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static booking.constant.ProjectConstant.*;
import static booking.util.PrepareStatement.prepareStatement;

public class MySQLBoardingGroupDAO implements BoardingGroupDAO {

    static Logger logger = Logger.getLogger(DBConnection.class.getName());

    // Method to insert a boarding group
    @Override
    public void insert(BoardingGroup boardingGroup) {
        Object[] values = {boardingGroup.getFlightId(), boardingGroup.getGroup(), boardingGroup.getPosition()};
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = prepareStatement(connection, BOARDING_GROUP_SQL_INSERT, true, values)) {
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    boardingGroup.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating boarding group failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            logger.severe("Failed to insert boarding group: " + e);
            throw new DAOException(e);
        }
    }

    // Method to find a boarding group by id
    @Override
    public Optional<BoardingGroup> findById(Integer id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = prepareStatement(connection, BOARDING_GROUP_FIND_BY_ID, false)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(mapRowToBoardingGroup(resultSet));
            }
        } catch (SQLException e) {
            logger.severe("Failed to find boarding group: " + e);
            throw new DAOException(e);
        }
        return Optional.empty();
    }

    // Method to get all boarding groups
    @Override
    public List<BoardingGroup> findAll() {
        List<BoardingGroup> boardingGroups = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = prepareStatement(connection, BOARDING_GROUP_FIND_ALL, false);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                boardingGroups.add(mapRowToBoardingGroup(resultSet));
            }
        } catch (SQLException e) {
            logger.severe("Failed to find all boarding groups: " + e);
            throw new DAOException(e);
        }
        return boardingGroups;
    }

    // Method to update a boarding group
    @Override
    public void update(BoardingGroup boardingGroup) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = prepareStatement(connection, BOARDING_GROUP_UPDATE, false)) {
            statement.setInt(1, boardingGroup.getFlightId());
            statement.setString(2, boardingGroup.getGroup());
            statement.setInt(3, boardingGroup.getPosition());
            statement.setInt(4, boardingGroup.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to update boarding group: " + e);
            throw new DAOException(e);
        }
    }

    // Method to delete a boarding group by ID
    @Override
    public void delete(Integer id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = prepareStatement(connection, BOARDING_GROUP_DELETE, false)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to delete boarding group: " + e);
            throw new DAOException(e);
        }
    }

    // Method to delete all boarding groups
    @Override
    public void deleteAll() {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = prepareStatement(connection, BOARDING_GROUP_DELETE_ALL, false)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to delete all boarding groups: " + e);
            throw new DAOException(e);
        }
    }

    private BoardingGroup mapRowToBoardingGroup(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("boarding_group_id");
        int flightId = resultSet.getInt("flight_id");
        String group = resultSet.getString("group");
        int position = resultSet.getInt("position");
        return new BoardingGroup(id, flightId, group, position);
    }
}

