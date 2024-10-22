package booking.service;

import booking.constant.ProjectConstant.FactoryType;
import booking.exception.DAOException;
import booking.model.Airport;
import booking.services.AirportService;
import booking.factory.DAOFactory;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertThrows;

public class jdbcairporttests {

    private AirportService airportService;
    private Airport airport1;

    @Before
    public void setUp() throws DAOException, SQLException {
        this.airportService = new AirportService(DAOFactory.getDAOFactory(FactoryType.MYSQL));
        airportService.deleteAllAirports();

        airport1 = new Airport("Los Angeles International Airport", "Los Angeles", "LAX", "USA");
        airportService.createAirport(airport1);
    }

    @Test
    public void testAddAirport() {
        Airport dbAirport = airportService.getAirportById(airport1.getId()).orElse(null);
        assert airport1.equals(dbAirport);
    }

    @Test
    public void testUpdateAirport() throws SQLException {
        Airport updatedAirport = new Airport(airport1.getId(), "San Francisco International Airport", "San Francisco", "SFO", "USA");

        airportService.updateAirport(updatedAirport);
        Airport dbAirport = airportService.getAirportById(airport1.getId()).orElse(null);
        assert updatedAirport.equals(dbAirport);
    }

    @Test
    public void testDeleteAirport() {
        airportService.deleteAirport(airport1.getId());

        assertThrows(DAOException.class, () -> airportService.getAirportById(airport1.getId()));
    }

    @Test
    public void testRemoveAllAirports() {
        airportService.deleteAllAirports();
        assert airportService.getAllAirports().isEmpty();
    }
}
