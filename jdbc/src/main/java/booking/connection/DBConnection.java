package booking.connection;

import booking.util.DAOProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import static booking.constant.ProjectConstant.*;

public class DBConnection {

    static Logger logger = Logger.getLogger(DBConnection.class.getName());

    private static DBConnection instance;

    DAOProperties properties = new DAOProperties(PROPERTY_KEY_NAME);

    private final String url = properties.getProperty(PROPERTY_URL, true);

    private final String password = properties.getProperty(PROPERTY_PASSWORD, false);

    private final String userName = properties.getProperty(PROPERTY_USER, password != null);

    private DBConnection() {
        try{
            String driverClassName = properties.getProperty(PROPERTY_DRIVER, false);
            Class.forName(driverClassName);
        }
        catch (Exception e){
            logger.severe("Failed to load properties file: " + e);
        }
    }

    public static Connection getConnection() throws SQLException {
        if (instance == null) {
            instance = new DBConnection();
            logger.info("Connection established");
        }
        return DriverManager.getConnection(instance.url, instance.userName, instance.password);
    }
}
