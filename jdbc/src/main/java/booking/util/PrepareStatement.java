package booking.util;

import java.sql.*;

public class PrepareStatement {

    public static PreparedStatement prepareStatement(Connection connection, String sql, boolean returnGeneratedKeys, Object... values) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);

        for (int i = 0; i < values.length; i++) {
            preparedStatement.setObject(i + 1, values[i]);
        }

        return preparedStatement;
    }
}
