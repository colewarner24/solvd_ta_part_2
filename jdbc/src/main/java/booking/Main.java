package booking;

import booking.connection.DBConnection;
import booking.dao.jdbc.MySQLUserDAO;
import booking.model.User;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        User user = new User("Cole", "Warner", "19cowarner@gmail.com", "password");
        MySQLUserDAO mySQLUserDAO = new MySQLUserDAO();
        mySQLUserDAO.create(user);
    }
}
