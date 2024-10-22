package booking.services;

import booking.dao.PaymentDAO;
import booking.dao.jdbc.MySQLPaymentDAO;
import booking.exception.DAOException;
import booking.factory.DAOFactory;
import booking.model.Payment;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PaymentService {

    private final PaymentDAO paymentDAO;

    public PaymentService(DAOFactory daoFactory) throws DAOException {
        this.paymentDAO = daoFactory.getPaymentDAO();
    }

    public PaymentService() {
        this.paymentDAO = new MySQLPaymentDAO();
    }

    public void createPayment(Payment payment) throws SQLException {
        paymentDAO.create(payment);
    }

    public Optional<Payment> getPayment(Integer id) {
        return paymentDAO.findById(id);
    }

    public void updatePayment(Payment payment) throws SQLException {
        paymentDAO.update(payment);
    }

    public void deletePayment(Integer paymentId) {
        paymentDAO.delete(paymentId);
    }

    public List<Payment> getAllPayments() {
        return paymentDAO.getAll();
    }

    public void deleteAllPayments() {
        paymentDAO.deleteAll();
    }
}
