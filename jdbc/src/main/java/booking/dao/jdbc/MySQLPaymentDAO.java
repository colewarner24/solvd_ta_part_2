package booking.dao.jdbc;

import booking.connection.DBConnection;
import booking.dao.PaymentDAO;
import booking.exception.DAOException;
import booking.model.Payment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import static booking.constant.ProjectConstant.*;

public class MySQLPaymentDAO implements PaymentDAO {

    static Logger logger = Logger.getLogger(DBConnection.class.getName());

    public void create(Payment payment) {
        Object[] values = {payment.getBookingId(), payment.getAmount(), payment.getPaymentDate()};
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(PAYMENTS_SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            for (int i = 0; i < values.length; i++) {
                statement.setObject(i + 1, values[i]);
            }
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    payment.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating payment failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            logger.severe("Failed to create payment: " + e);
            throw new DAOException(e);
        }
    }

    public Optional<Payment> findById(Integer paymentId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(PAYMENTS_FIND_BY_ID)) {
            preparedStatement.setInt(1, paymentId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return Optional.of(mapRowToPayment(rs));
            }
        } catch (SQLException e) {
            logger.severe("Failed to find payment: " + e);
            throw new DAOException(e);
        }
        return Optional.empty();
    }

    public List<Payment> getAll() {
        List<Payment> paymentList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(PAYMENTS_FIND_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                paymentList.add(mapRowToPayment(rs));
            }
        } catch (SQLException e) {
            logger.severe("Failed to get all payments: " + e);
            throw new DAOException(e);
        }
        return paymentList;
    }

    public void update(Payment payment) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(PAYMENTS_UPDATE)) {
            preparedStatement.setInt(1, payment.getBookingId());
            preparedStatement.setDouble(2, payment.getAmount());
            preparedStatement.setTimestamp(3, payment.getPaymentDate());
            preparedStatement.setInt(4, payment.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to update payment: " + e);
            throw new DAOException(e);
        }
    }

    public void delete(Integer paymentId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(PAYMENTS_DELETE)) {
            ps.setInt(1, paymentId);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to delete payment: " + e);
            throw new DAOException(e);
        }
    }

    public void deleteAll() {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(PAYMENTS_DELETE_ALL)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.severe("Failed to delete all payments: " + e);
            throw new DAOException(e);
        }
    }

    private Payment mapRowToPayment(ResultSet rs) throws SQLException {
        return new Payment(
                rs.getInt("payment_id"),
                rs.getInt("booking_id"),
                rs.getDouble("amount"),
                rs.getTimestamp("payment_date")
        );
    }
}
