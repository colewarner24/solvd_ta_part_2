package booking.services;

import booking.dao.UserDAO;
import booking.dao.jdbc.MySQLUserDAO;
import booking.exception.DAOException;
import booking.factory.DAOFactory;
import booking.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserService {

    private final UserDAO userDAO;

    public UserService(DAOFactory daoFactory) throws DAOException {
        this.userDAO = daoFactory.getUserDAO();
    }

    public UserService() {
        this.userDAO = new MySQLUserDAO();
    }

    public void createUser(User user) throws SQLException {
        userDAO.create(user);
    }

    public Optional<User> getUser(Integer id) {
        return userDAO.findById(id);
    }

    public void updateUser(User user) throws SQLException {
        userDAO.update(user);
    }

    public void deleteUser(Integer userId) {
        userDAO.delete(userId);
    }

    public List<User> getAllUsers() {
        return userDAO.getAll();
    }

    public void deleteAllUsers() {
        userDAO.deleteAll();
    }
}