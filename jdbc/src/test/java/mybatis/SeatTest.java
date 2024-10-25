package mybatis;

import booking.model.Seat;
import booking.mybatis.services.SeatService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SeatTest {

    private Seat seat1;
    private SeatService seatService;

    @Before
    public void setUp() {
        seatService = new SeatService();
        seat1 = new Seat(5, "A1", "economy", true);
        seatService.create(seat1);
    }

    @Test
    public void testCreateSeat() {
        Seat dbSeat = seatService.findById(seat1.getId());
        assert seat1.equals(dbSeat);
    }

    @Test
    public void updateSeat() {
        Seat seatUpdate = new Seat(seat1.getId(), seat1.getFlightId(), "B2", "business", false);
        seatService.update(seatUpdate);
        Seat dbSeat = seatService.findById(seat1.getId());
        assert seatUpdate.equals(dbSeat);
    }

    @Test
    public void deleteSeat() {
        seatService.delete(seat1.getId());
        Seat dbSeat = seatService.findById(seat1.getId());
        assert dbSeat == null;
    }

    @After
    public void tearDown() {
        seatService.delete(seat1.getId());
    }
}
