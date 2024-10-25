package mybatis;

import booking.model.Passenger;
import booking.mybatis.services.PassengerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PassengerTest {

    private Passenger passenger1;
    private PassengerService passengerService;

    @Before
    public void setUp() {
        passengerService = new PassengerService();
        passenger1 = new Passenger(16, 51);
        passengerService.create(passenger1);
    }

    @Test
    public void testCreatePassenger() {
        Passenger db_passenger = passengerService.findById(passenger1.getId());
        assert passenger1.equals(db_passenger);
    }

    @Test
    public void updatePassenger() {
        Passenger passengerUpdate = new Passenger(passenger1.getId(), passenger1.getBookingId(), 52);
        passengerService.update(passengerUpdate);
        Passenger db_passenger = passengerService.findById(passenger1.getId());
        assert passengerUpdate.equals(db_passenger);
    }

    @Test
    public void deletePassenger() {
        passengerService.delete(passenger1.getId());
        Passenger db_passenger = passengerService.findById(passenger1.getId());
        assert db_passenger == null;
    }

    @After
    public void tearDown() {
        passengerService.delete(passenger1.getId());
    }
}
