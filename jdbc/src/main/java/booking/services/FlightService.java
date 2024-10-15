package booking.services;

import booking.dao.FlightDAO;
import booking.dao.jdbc.MySQLFlightDAO;
import booking.exception.DAOException;
import booking.factory.DAOFactory;
import booking.model.Flight;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FlightService {

    private final FlightDAO flightDAO;

    public FlightService(DAOFactory daoFactory) throws DAOException {
        this.flightDAO = daoFactory.getFlightDAO();
    }

    public FlightService() {
        this.flightDAO = new MySQLFlightDAO();
    }

    public void createFlight(Flight flight) throws SQLException {
        flightDAO.create(flight);
    }

    public Optional<Flight> getFlight(Integer id) {
        return flightDAO.findById(id);
    }

    public void updateFlight(Flight flight) throws SQLException {
        flightDAO.update(flight);
    }

    public void deleteFlight(Integer flightId) {
        flightDAO.delete(flightId);
    }

    public List<Flight> getAllFlights() {
        return flightDAO.getAll();
    }

    public void deleteAllFlights() {
        flightDAO.deleteAll();
    }
}