package booking.dao;

import booking.model.Payment;
import java.util.List;
import java.util.Optional;

public interface PaymentDAO {

    void create(Payment payment);

    Optional<Payment> findById(Integer paymentId);

    List<Payment> getAll();

    void update(Payment payment);

    void delete(Integer paymentId);

    void deleteAll();
}
