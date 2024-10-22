package jdbc;

import booking.constant.ProjectConstant.FactoryType;
import booking.exception.DAOException;
import booking.model.Airline;
import booking.model.Airport; // Import the Airport model
import booking.model.Flight;  // Import the Flight model
import booking.services.AirlineService; // Import the AirlineService
import booking.services.AirportService;  // Import the AirportService
import booking.services.FlightService;   // Import the FlightService
import booking.factory.DAOFactory;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class jdbcflighttests {

    private FlightService flightService;
    private AirlineService airlineService;
    private AirportService airportService;
    private Flight flight1;
    private Airline testAirline;
    private Airport testDepartureAirport;
    private Airport testArrivalAirport;

    @Before
    public void setUp() throws DAOException, SQLException {
        this.flightService = new FlightService(DAOFactory.getDAOFactory(FactoryType.MYSQL));
        this.airlineService = new AirlineService(DAOFactory.getDAOFactory(FactoryType.MYSQL)); // Initialize AirlineService
        this.airportService = new AirportService(DAOFactory.getDAOFactory(FactoryType.MYSQL)); // Initialize AirportService
        airlineService.deleteAllAirlines(); // Ensure the airline table is empty
        airportService.deleteAllAirports(); // Ensure the airport table is empty

        testAirline = new Airline("Test Airline"); // Create a test airline
        airlineService.createAirline(testAirline); // Save the airline to the database

        testDepartureAirport = new Airport("Test Departure Airport", "DPT", "City A", "USA"); // Create a departure airport
        testArrivalAirport = new Airport("Test Arrival Airport", "ARR", "City B", "USA");     // Create an arrival airport
        airportService.createAirport(testDepartureAirport); // Save the departure airport to the database
        airportService.createAirport(testArrivalAirport);     // Save the arrival airport to the database

        flight1 = new Flight(0, testAirline.getId(), testDepartureAirport.getId(), testArrivalAirport.getId(), "2024-10-01 10:00:00", "FL123", "2024-10-01 12:00:00");
        flightService.createFlight(flight1); // Create a flight associated with the test airline
    }

    @Test
    public void testCreateFlight() {
        Optional<Flight> db_flight = flightService.getFlight(flight1.getId());
        assertTrue(db_flight.isPresent());
        assertEquals(flight1, db_flight.get());
    }

    @Test
    public void testUpdateFlight() throws SQLException {
        Flight flight = new Flight(flight1.getId(), flight1.getAirlineId(), flight1.getDepartureAirportId(), flight1.getArrivalAirportId(), "2024-10-01 11:00:00", flight1.getFlightNumber(), "2024-10-01 13:00:00");

        flightService.updateFlight(flight);
        Optional<Flight> db_flight = flightService.getFlight(flight1.getId());
        assertTrue(db_flight.isPresent());
        assertEquals(flight, db_flight.get());
    }

    @Test
    public void testDeleteFlight() {
        flightService.deleteFlight(flight1.getId());

        Optional<Flight> db_flight = flightService.getFlight(flight1.getId());
        assertFalse(db_flight.isPresent());
    }

    @Test
    public void testDeleteAllFlights() {
        flightService.deleteAllFlights();
        assertTrue(flightService.getAllFlights().isEmpty());
    }
}
