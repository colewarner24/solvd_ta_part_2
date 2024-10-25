package mybatis;

import booking.model.Payment;
import booking.mybatis.services.PaymentService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;

public class PaymentTest {

    private Payment payment1;
    private PaymentService paymentService;

    @Before
    public void setUp() {
        paymentService = new PaymentService();
        payment1 = new Payment(15, 100.00, new Timestamp(System.currentTimeMillis()));
        paymentService.create(payment1);
    }

    @Test
    public void testCreatePayment() {
        Payment db_payment = paymentService.findById(payment1.getId());
        assert payment1.equals(db_payment);
    }

    @Test
    public void updatePayment() {
        Payment paymentUpdate = new Payment(payment1.getId(), payment1.getBookingId(), 150.00, payment1.getPaymentDate());
        paymentService.update(paymentUpdate);
        Payment db_payment = paymentService.findById(payment1.getId());
        System.out.println(paymentUpdate + "\n" + db_payment);
        assert paymentUpdate.equals(db_payment);
    }

    @Test
    public void deletePayment() {
        paymentService.delete(payment1.getId());
        Payment db_payment = paymentService.findById(payment1.getId());
        assert db_payment == null;
    }

    @After
    public void tearDown() {
        paymentService.delete(payment1.getId());
    }
}
