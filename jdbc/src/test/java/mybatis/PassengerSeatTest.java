package mybatis;

import booking.model.PassengerSeat;
import booking.mybatis.services.PassengerSeatService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PassengerSeatTest {

    private PassengerSeat passengerSeat1;
    private PassengerSeatService passengerSeatService;

    @Before
    public void setUp() {
        passengerSeatService = new PassengerSeatService();
        passengerSeat1 = new PassengerSeat(1, 1);
        passengerSeatService.create(passengerSeat1);
    }

    @Test
    public void testCreatePassengerSeat() {
        PassengerSeat db_passengerSeat = passengerSeatService.findById(passengerSeat1.getId());
        assert passengerSeat1.equals(db_passengerSeat);
    }

    @Test
    public void updatePassengerSeat() {
        PassengerSeat passengerSeatUpdate = new PassengerSeat(passengerSeat1.getId(), passengerSeat1.getPassengerId(), "14B"); // Updating seatNumber
        passengerSeatService.update(passengerSeatUpdate);
        PassengerSeat db_passengerSeat = passengerSeatService.findById(passengerSeat1.getId());
        assert passengerSeatUpdate.equals(db_passengerSeat);
    }

    @Test
    public void deletePassengerSeat() {
        passengerSeatService.delete(passengerSeat1.getId());
        PassengerSeat db_passengerSeat = passengerSeatService.findById(passengerSeat1.getId());
        assert db_passengerSeat == null;
    }

    @After
    public void tearDown() {
        passengerSeatService.delete(passengerSeat1.getId());
    }
}
