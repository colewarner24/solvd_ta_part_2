package booking.dao.jdbc;

import booking.connection.DBConnection;
import booking.dao.UserDAO;
import booking.exception.DAOException;
import booking.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import booking.constant.ProjectConstant;

import static booking.constant.ProjectConstant.USER_SQL_INSERT;
import static booking.util.PrepareStatement.prepareStatement;

public class MySQLUserDAO implements UserDAO {

    static Logger logger = Logger.getLogger(DBConnection.class.getName());

    // Method to get all users
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM User";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = prepareStatement(connection, ProjectConstant.USER_FIND_ALL, false)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User(rs.getInt("user_id")
                        , rs.getString("first_name")
                        , rs.getString("last_name")
                        , rs.getString("email")
                        , rs.getString("password"));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Method to get a user by ID
    public User findById(Integer userId) {
        User user = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = prepareStatement(connection, ProjectConstant.USER_FIND_BY_ID, false, userId);) {

            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user = new User(rs.getInt("user_id")
                        , rs.getString("first_name")
                        , rs.getString("last_name")
                        , rs.getString("email")
                        , rs.getString("password"));

            }

        } catch (SQLException e) {
            logger.severe("Failed to find user: " + e);
            throw new DAOException(e);
        }
        if (user == null) {
            logger.severe("User not found");
            throw new DAOException("User not found");
        }
        return user;
    }

    // Method to create a user
    public void create(User user) {
        if (user.getId() > 0) {
            throw new IllegalArgumentException("User is already created");
        }
        Object[] values = {user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword()};
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement statement = prepareStatement(connection, USER_SQL_INSERT, true, values);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            logger.severe("Failed to create user: " + e);
            throw new DAOException(e);
        }
    }

    public void update(User user) {

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = prepareStatement(connection, ProjectConstant.USER_UPDATE, false)) {

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setInt(5, user.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.severe("Failed to update user: " + e);
            throw new DAOException(e);
        }
    }

    // Method to delete a user by ID
    public void delete(Integer userId) {

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = prepareStatement(connection, ProjectConstant.USER_DELETE, false)) {

            ps.setInt(1, userId);
            ps.executeUpdate();

        } catch (SQLException e) {
            logger.severe("Failed to delete user: " + e);
            throw new DAOException(e);
        }
    }

    public void deleteAll() {

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = prepareStatement(connection, ProjectConstant.USER_DELETE_ALL, false)) {

            ps.executeUpdate();

        } catch (SQLException e) {
            logger.severe("Failed to delete all users: " + e);
            throw new DAOException(e);
        }
    }
}

