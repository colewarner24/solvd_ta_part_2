package booking.factory;

import booking.dao.AirlinesDAO;
import booking.dao.AirportDAO;
import booking.dao.UserDAO;
import booking.dao.jdbc.MySQLAirlinesDAO;
import booking.dao.jdbc.MySQLAirportDAO;
import booking.dao.jdbc.MySQLUserDAO;

public class MySQLDAOFactory extends DAOFactory {

    public static DAOFactory getDAOFactory() {
        return new MySQLDAOFactory();
    }

    @Override
    public UserDAO getUserDAO() {
        return new MySQLUserDAO();
    }

    @Override
    public AirlinesDAO getAirlinesDAO() {
        return new MySQLAirlinesDAO();
    }

    @Override
    public AirportDAO getAirportDAO() {
        return new MySQLAirportDAO();
    }
}
