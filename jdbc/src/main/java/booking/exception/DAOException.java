package booking.exception;

import java.sql.SQLException;

public class DAOException extends RuntimeException {
    public DAOException(SQLException message) {
        super(message);
    }

    public DAOException(String message) {
        super(message);
    }
}
