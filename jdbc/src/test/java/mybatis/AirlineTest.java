package mybatis;

import booking.model.Airline;
import booking.mybatis.services.AirlineService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AirlineTest {

    private Airline airline1;
    private AirlineService airlineService;

    @Before
    public void setUp() {
        airlineService = new AirlineService();
        airline1 = new Airline("Delta Airlines");
        airlineService.create(airline1);
    }

    @Test
    public void testCreateAirline() {
        Airline db_airline = airlineService.findById(airline1.getId());
        System.out.println("Airline from DB: " + db_airline);
        assert airline1.equals(db_airline);
    }

    @Test
    public void updateAirline() {
        Airline updatedAirline = new Airline(airline1.getId(), "Delta Airlines Updated");
        airlineService.update(updatedAirline);
        Airline db_airline = airlineService.findById(airline1.getId());
        assert updatedAirline.equals(db_airline);
    }

    @Test
    public void deleteAirline() {
        airlineService.delete(airline1.getId());
        Airline db_airline = airlineService.findById(airline1.getId());
        assert db_airline == null;
    }

    @After
    public void tearDown() {
        airlineService.delete(airline1.getId());
    }
}
