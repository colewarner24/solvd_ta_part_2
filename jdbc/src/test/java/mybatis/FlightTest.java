package mybatis;

import booking.model.Flight;
import booking.mybatis.services.FlightService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FlightTest {

    private Flight flight1;
    private FlightService flightService;

    @Before
    public void setUp() {
        flightService = new FlightService();
        flight1 = new Flight(9, 7, 21, "2024-10-25 14:00:00", "AA123", "2024-10-25 16:30:00");
        flightService.create(flight1);
    }

    @Test
    public void testCreateFlight() {
        Flight db_flight = flightService.findById(flight1.getFlightId());
        assert flight1.equals(db_flight);
    }

    @Test
    public void updateFlight() {
        Flight flightUpdate = new Flight(flight1.getFlightId(), flight1.getAirlineId(), flight1.getDepartureAirportId(),
                flight1.getArrivalAirportId(), flight1.getDepartureTime(), "AA456",
                flight1.getArrivalTime());
        flightService.update(flightUpdate);
        Flight db_flight = flightService.findById(flight1.getFlightId());
        assert flightUpdate.equals(db_flight);
    }

    @Test
    public void deleteFlight() {
        flightService.delete(flight1.getFlightId());
        Flight db_flight = flightService.findById(flight1.getFlightId());
        assert db_flight == null;
    }

    @After
    public void tearDown() {
        flightService.delete(flight1.getFlightId());
    }
}
