package jdbc;

import booking.constant.ProjectConstant.FactoryType;
import booking.exception.DAOException;
import booking.model.Airline;
import booking.services.AirlineService;
import booking.factory.DAOFactory;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertThrows;

public class jdbcairlinetests {

    private AirlineService airlineService;
    private Airline airline1;

    @Before
    public void setUp() throws DAOException, SQLException {
        this.airlineService = new AirlineService(DAOFactory.getDAOFactory(FactoryType.MYSQL));
        airlineService.deleteAllAirlines();

        airline1 = new Airline("American Airlines");
        airlineService.createAirline(airline1);
    }

    @Test
    public void testCreateAirline() {
        Airline db_airline = airlineService.getAirline(airline1.getId());
        assert airline1.equals(db_airline);
    }

    @Test
    public void testUpdateAirline() throws SQLException {
        Airline airline = new Airline(airline1.getId(), "Delta Airlines");

        airlineService.updateAirline(airline);
        Airline db_airline = airlineService.getAirline(airline1.getId());
        assert airline.equals(db_airline);
    }

    @Test
    public void testDeleteAirline() {
        airlineService.deleteAirline(airline1.getId());

        assertThrows(DAOException.class, () -> airlineService.getAirline(airline1.getId()));
    }

    @Test
    public void testDeleteAllAirlines() {
        airlineService.deleteAllAirlines();
        assert airlineService.getAllAirlines().isEmpty();
    }
}
