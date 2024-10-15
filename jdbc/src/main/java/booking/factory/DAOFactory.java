package booking.factory;

import booking.constant.ProjectConstant.FactoryType;
import booking.dao.UserDAO;
import booking.dao.AirlinesDAO;
import booking.dao.AirportDAO;

public abstract class DAOFactory {


    public static DAOFactory getDAOFactory(FactoryType whichFactory) {
        switch (whichFactory) {
            case MYSQL:
                return new MySQLDAOFactory();
            case ORACLE:
                return null;
            case POSTGRESQL:
                return null;
        }
        return null;
    }

    public abstract UserDAO getUserDAO();

    public abstract AirlinesDAO getAirlinesDAO();

    public abstract AirportDAO getAirportDAO();
}
