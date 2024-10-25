package mybatis;

import booking.model.Airport;
import booking.mybatis.services.AirportService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AirportTest {

    private Airport airport1;
    private AirportService airportService;

    @Before
    public void setUp() {
        airportService = new AirportService();
        airport1 = new Airport("San Francisco International", "San Francisco", "SFO", "USA");
        airportService.create(airport1);
    }

    @Test
    public void testCreateAirport() {
        Airport db_airport = airportService.findById(airport1.getId());
        System.out.println("Airport from DB: " + db_airport);
        assert airport1.equals(db_airport);
    }

    @Test
    public void testUpdateAirport() {
        airport1.setCity("Los Angeles");
        airport1.setCode("LAX");
        airportService.update(airport1);
        Airport db_airport = airportService.findById(airport1.getId());
        assertEquals(airport1, db_airport);
    }

    @Test
    public void testDeleteAirport() {
        airportService.delete(airport1.getId());
        Airport db_airport = airportService.findById(airport1.getId());
        assertNull(db_airport);
    }

    @After
    public void tearDown() {
        airportService.delete(airport1.getId());
    }
}
